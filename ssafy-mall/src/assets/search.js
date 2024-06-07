// 네이버 검색광고 플랫폼에서 발급받은 Access Key, Secret Key, Customer ID 입력 

// https://ads.naver.com 

// 1-1. 광고시스템에 로그인.

// 1-2. [도구 -> API 사용 관리] 메뉴 클릭

// 1-3. [네이버 검색광고 API 서비스 신청] 버튼 클릭

// 1-4. API키 자동 발급


const accessLicense = "01000000000f72a302183100897f2e234da7642248d65a266b4a1434de0b45b01be8ed5b44";
const secretKey = "AQAAAAAPcqMCGDEAiX8uI02nZCJIgFSHuXtDx0OkD3fauz2EyA==";
const customerId = "3216110";

//CORS우회 프록시 서버
const proxyURL = "https://cors-anywhere.herokuapp.com/";

// 네이버 키워드 검색 API를 이용하여 주어진 키워드에 대한 검색 결과 반환
export async function fetchKeyword(keywords) {
  // API 호출에 필요한 인자들을 정의
  const method = "GET";
  const api_url = "/keywordstool";
  const timestamp = Date.now().toString();

  // HMAC-SHA256 암호화를 이용하여 서명(signature)을 생성
  const signature = await createSignature(secretKey, timestamp, method, api_url);

  // 생성한 서명과 함께 API를 호출하여 검색 결과 반환
  const response = await fetch(
    `${proxyURL}https://api.naver.com/keywordstool?hintKeywords=${encodeURIComponent(keywords)}&showDetail=1`,
    {
      headers: {
        "X-Timestamp": timestamp,
        "X-API-KEY": accessLicense,
        "X-CUSTOMER": customerId,
        "X-Signature": signature,
      },
    }
  );

  // 검색 결과를 출력하는 함수를 호출
  const data = await response.json();
  const result = []
  for (let i = 0; i < data.keywordList.length && i < 10; i++) {
    result.push(data.keywordList[i].relKeyword);
  }
  return result;

}

// HMAC-SHA256 암호화를 이용하여 서명(signature)을 생성
async function createSignature(secretKey, timestamp, method, api_url) {
  // TextEncoder를 이용하여 입력 데이터를 UTF-8 형식으로 인코딩
  const encoder = new TextEncoder();
  const data = encoder.encode(`${timestamp}.${method}.${api_url}`);

  // 암호화에 사용할 키를 생성
  const key = await crypto.subtle.importKey("raw", encoder.encode(secretKey), { name: "HMAC", hash: "SHA-256" }, false, ["sign"]);

  // 생성한 키와 입력 데이터를 이용하여 서명을 생성
  const signatureArrayBuffer = await crypto.subtle.sign("HMAC", key, data);

  // 서명 결과를 base64로 인코딩
  const signature = btoa(String.fromCharCode(...new Uint8Array(signatureArrayBuffer)));
  return signature;
}