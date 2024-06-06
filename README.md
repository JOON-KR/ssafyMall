<div align="center">
  
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
|`권서현`|`윤여준`|`이소연`|
|:---:|:---:|:---:|
</br>

### ⚙️ 개발 환경
- `Java 17`
- `JDK 17.0.1`
- **IDE** : STS 4, Eclipse, IntelliJ
- **Framework** : Springboot, Spring-Security
- **Database** : My SQL
- **ORM** : Mybatis
- **api** : google Natural Language Entity, Naver keyWord AD

</br>

## 📌 주요 기능
#### 로그인
- JWT 인증
- Spring-Security
- HS256 / Base64 / Bcrypt

### 리뷰

#### 리뷰 시각화
- Sentiment 기반 상품 평점 관리, Natural Language Entity 기반 상품 간 유사도 분석 알고리즘(Cosine Similarity),사용자간 유사도 분석 알고리즘 (Jaccard Similarity)을 통해 긍정적 키워드, 부정적 키워드를 구분하여 워드 클라우드 데이터 시각화(Entity WordCloud)

#### 상품 추천
- 사용자간 유사도 분석 알고리즘 (Jaccard Similarity)과 Natural Language Entity 기반 상품 간 유사도 분석 알고리즘(Cosine Similarity)을 통한 상품 추천
- Naver ad api를 활용하여 상품 검색 시 연관 검색어를 추출 후 상품 추천
    

</br>

## 📌 겪었던 어려움과 해결 과정
1. **초기설계의 부재에 따른 회의 증가**
- 어려움 쓰기
2. **초기설계의 부재에 따른 회의 증가**
    


</br>

## 💓 소감
> 권서현
- 
> 윤여준
- 
> 이소연
- 삼성 청년 sw 아카데미에서 배웠던 기술들을 토대로 ssafy 프로젝트 외에 새로운 도전을 시도했습니다. 아직 부족한 부분이 많지만 지난 프로젝트 때 시도해보고 싶었던 Spring-Security를 통해 로그인 보안을 구현했습니다.
그리고 배웠던 api 외에 새로운 naver ad api를 가지고 이번 쇼핑몰 프로젝트에 적합한 기능을 구현해보며 어려움도 겪었지만 더 성장할 수 있던 시간이었습니다.
하반기 프로젝트 때는 더 다양한 api를 구현하고 back, front에서의 에러 처리에 대해서도 공부를 해보고 싶습니다. 
