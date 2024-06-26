![image](https://github.com/JOON-KR/ssafyMall/assets/104131284/4474ebe2-a226-4a4c-98a3-e34129a51af1)<div align="center">
  
  # SSAFY Mall 프로젝트 🚩
  다양한 API를 활용해 사용자 맞춤 상품을 추천하는 사이트
</div>
</br>


## 🖥️ 프로젝트 소개
- Natural Language Entity, GCP Sentiment, Naver ad api, wordCloud 시각화를 통해 리뷰의 긍정적, 부정적 감정을 한 눈에 제공
- 리뷰 센티멘트 분석 및 평점 산정 후 제공
- 리뷰에 Entity 수집 후 긍정적 Entity를 토대로 한 상품 간 코사인 유사도 분석 알고리즘 & 사용자 간 유사도 분석 알고리즘(Jaccard Similarity)을 통한 상품 추천 기능 제공

</br>

### 🕰️ 개발 기간
24.05.24 - 24.06.07
</br>

### 👥 멤버 소개
![image](https://github.com/JOON-KR/ssafyMall/assets/104131284/8cb15561-5896-498f-984f-456eeec40d1a)

</br>

### ⚙️ 개발 환경
- `Java 17`
- `JDK 17.0.1`
- **IDE** : STS 4, Eclipse, IntelliJ
- **Framework** : Springboot, Spring-Security
- **Database** : My SQL
- **ORM** : JPA
- **api** : google Natural Language Entity, Naver keyWord AD

</br>

## 📌 주요 기능
#### 로그인
- JWT 인증 ( AccessToken )
- Spring-Security 를 통한 관리자 / 유저 구분
- HS256 / Base64 / Bcrypt 알고리즘 사용

### JPA
- 제한된 개발 기간과 개발 편의성을 고려하여 JPA를 선택

### 리뷰 


#### 리뷰 시각화
- Sentiment 기반 상품 평점 관리 ( Score총점 avg 환산 후 총점 5점의 별점으로 반환 )
-  Natural Language Entity 기반 상품 간 유사도 분석 알고리즘(Cosine Similarity)
    : 상품간 긍정 키워드 수집 후 모든 상품간 Cosine Similarlity 분석하여 유사한 특성을 가진 추천상품 리스트 제공
-   NLP의 엔티티 추출 기능을 이용해 긍정적 키워드, 부정적 키워드를 구분하여 워드 클라우드 데이터 시각화(Entity WordCloud)

#### 유저간 비교 상품 추천
- 유저의 찜 상품 목록간 Jaccard Similarity 분석
    : 유사한 관심사를 지닌 유저들을 클러스터링 하고, 해당 유저들이 많은 관심을 보이는 상품 중에서 내가 찜하지 않은 목록을
      선별, 추천상품 리스트를 제공 (메인페이지) 
- Naver ad api를 활용하여 상품 검색 시 연관 검색어를 추출 후 상품 추천
  : 실제 'LIKE' sql 뿐만 아니라 api를 통해 반환받은 유사 키워드 또는 연관 키워드를 제공받아 해당 키워드의 'LIKE' recodes를 불러와
     검색 리스트를 제공
    

</br>


## 시연 영상

### 메인 페이지
![메인페이지](https://github.com/JOON-KR/ssafyMall/assets/171137407/6aa7be9b-c60a-4b64-983d-e2e68d75ecfb)


### 아이템 검색
![검색](https://github.com/JOON-KR/ssafyMall/assets/171137407/babff6df-0990-49ba-b6d4-82cd0132600d)


### 아이템 상세
![아이템상세](https://github.com/JOON-KR/ssafyMall/assets/171137407/f69372e7-bdb3-4bb8-9d5c-dced55916cd4)


## 📌 겪었던 어려움과 해결 과정
1. **최적화되지 않은 설계로 시간소요**
   - DB 저장방식을 전면 수정하고, img 파일로 인한 서버 과부하를 줄이기 위해 분산
2. **Synthetic Data생성 과정의 어려움**
   - Generic Modal 설계의 보완


</br>

## 💓 소감
> 권서현
- 추천 알고리즘을 적용하여 서비스를 구현할 수 있어 뿌듯한 프로젝트였습니다. 프로젝트 진행 중 다양한 아이디어를 떠올릴 수 있었습니다. SSAFY 2학기 프로젝트를 통해 이를 구체화하는 경험을 하고 싶습니다.
> 윤여준
- 지난 관통 프로젝트에서 시간이 부족해 구상만 하고 구현하지 못했던 알고리즘을 구현해볼 수 있는 기회가 되었습니다. 이번 프로젝트를 진행하면서 보완하고 싶은 부분이 많이 생겨 앞으로 더 공부하고 직접 구현해보고 싶은 것들이 많이 생기게 된 뜻깊은 프로젝트가 되었고, 재미삼아 써본 AI관련 api와 그밖의 api 기능들이 생각보다 쓸모가 많고 더욱 다양한 분야에 확장하여 적용할 수 있겠다는 생각이 들어 다음엔 더 제대로 사용해보고자 합니다. 다음 프로젝트에서는 이러한 기능들을 최적화할 수 있는 알고리즘 외에 다양한 최적화나, 데이터 분석을 도와주는 라이브러리를 사용해볼 계획입니다.
> 이소연
- 삼성 청년 sw 아카데미에서 배웠던 기술들을 토대로 ssafy 프로젝트 외에 새로운 도전을 시도했습니다. 아직 부족한 부분이 많지만 지난 프로젝트 때 시도해보고 싶었던 Spring-Security를 통해 로그인 보안을 구현했습니다.
그리고 배웠던 api 외에 새로운 naver ad api를 가지고 이번 쇼핑몰 프로젝트에 적합한 기능을 구현해보며 어려움도 겪었지만 더 성장할 수 있던 시간이었습니다.
하반기 프로젝트 때는 더 다양한 api를 구현하고 back, front에서의 에러 처리에 대해서도 공부를 해보고 싶습니다. 
