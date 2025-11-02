#### 1.0.0 (2025-11-02)

##### Build System / Dependencies

*  upgrade Gradle versions ([45f688ab](https://github.com/Fiddich-Dev/java-lotto-8/commit/45f688abfdd72879d78271f7d217266b62e51d1e))

##### Chores

*  공백 제거 ([655e4426](https://github.com/Fiddich-Dev/java-lotto-8/commit/655e4426467737bcd743afa65b2e0dedf30f907f))
*  코드 포멧팅, 파일위치 변경 ([9169c4b6](https://github.com/Fiddich-Dev/java-lotto-8/commit/9169c4b6d7720d78d6bac5c70686fff24e7679b1))

##### Documentation Changes

* **readme:**
  *  readme에 진행상황 업데이트 ([ca97d8bf](https://github.com/Fiddich-Dev/java-lotto-8/commit/ca97d8bf2cca254ff4c93289b694159967a49c17))
  *  readme 구현한것 체크표시 ([5b10127e](https://github.com/Fiddich-Dev/java-lotto-8/commit/5b10127ef2bfb640cd4e31d8203e5be230775c23))
  *  프로젝트 개요와 요구사항, 제한사항 작성 ([7d8b87a8](https://github.com/Fiddich-Dev/java-lotto-8/commit/7d8b87a816738ebacfa6f1c3ccdd5bb45f28b55b))

##### New Features

*  컨트롤러 로직 마지막에 Scanner 종료하는 메서드 추가 ([7e92f1e5](https://github.com/Fiddich-Dev/java-lotto-8/commit/7e92f1e5f6b1d2d07555905017c671ec2fc580d6))
*  로또 결과의 수익률을 계산하는 기능 구현 ([b7d942d1](https://github.com/Fiddich-Dev/java-lotto-8/commit/b7d942d1d002ad6a8d6217df2dd4e40eb6a60c80))
*  당첨 결과를 반환하는 LottoResultChecker 구현후 적용 ([3ba4f15f](https://github.com/Fiddich-Dev/java-lotto-8/commit/3ba4f15febabf45e2d28fe3e0937a12e10fd11ce))
*  실행 코드 작성 ([e608d049](https://github.com/Fiddich-Dev/java-lotto-8/commit/e608d0494f7ae6c877b8d891a7ba1bfe57c9e381))
*  컨트롤러에 입력부터 출력까지 로직 작성 ([44c9dc03](https://github.com/Fiddich-Dev/java-lotto-8/commit/44c9dc039d180f2d8a7692d9f7157d73f7da1aae))
*  로또를 판매하는 객체 LottoStore 구현 ([f8ea05eb](https://github.com/Fiddich-Dev/java-lotto-8/commit/f8ea05eb80af3e5d50877673d108cb27d28bd0bc))
*  입력값을 의미있는데이터로 파싱하는 객체, 로또 컨트롤러 구현 ([1919f27f](https://github.com/Fiddich-Dev/java-lotto-8/commit/1919f27f841834ec36969c068338e979d946cabd))
*  당첨번호 객체 구현, 로또 당첨결과 확인 객체 구현 ([afb7af61](https://github.com/Fiddich-Dev/java-lotto-8/commit/afb7af61a9a26181a1a8cd6ca1429032ae6a0ea8))
*  setup project ([99b19647](https://github.com/Fiddich-Dev/java-lotto-8/commit/99b196479883400e460aec0c89ca28e4cdd34549))
* **retry:**  재시도 로직구현 ([9ac43efa](https://github.com/Fiddich-Dev/java-lotto-8/commit/9ac43efa547e6cbf86eb581a8fe97c1f208a4176))
* **input:**
  *  입력값이 비어있을떄 예외처리 추가 ([d4c64add](https://github.com/Fiddich-Dev/java-lotto-8/commit/d4c64add84fad3a4ea302f0721d664b3c3a4babf))
  *  입력값을 받는 view 구현 ([a493c248](https://github.com/Fiddich-Dev/java-lotto-8/commit/a493c2480cb7a2a67b9a5644ebf40af2e1a52dd6))
* **Lotto:**  Lotto 내부에 숫자범위 검증 로직 추가 ([0394e380](https://github.com/Fiddich-Dev/java-lotto-8/commit/0394e3803f8f6b88cbcb70b8d4db2a0f5b33dc45))
* **LottoRank:**  로또 순위 정렬기능 추가후 당첨금액 기준 오름차순으로 적용 ([ac51dfde](https://github.com/Fiddich-Dev/java-lotto-8/commit/ac51dfde8265c0fc43b1fec8c81494937d430bcc))
* **parser:**  당첨 번호 검증로직 추가 ([29528b8f](https://github.com/Fiddich-Dev/java-lotto-8/commit/29528b8f4a7b25aff0bb4a7207b7f65de3f078a3))
* **output:**  출력 view와 로또 등수에 따른 상금표 구현 ([f334bad9](https://github.com/Fiddich-Dev/java-lotto-8/commit/f334bad9aa272c371f79ba087ffb972177f86599))

##### Refactors

*  로또 생성기에서 숫자들을 정렬하는 로직을 뷰로 이동 ([3a5bf146](https://github.com/Fiddich-Dev/java-lotto-8/commit/3a5bf146496de648aeab072bb02c4d3bd4710a6a))
*  로또 생성 규칙과 생성하는 LottoGenerator 구현 ([89f06277](https://github.com/Fiddich-Dev/java-lotto-8/commit/89f0627757665352eda43f2d286499aa37377b3c))
* **parser:**
  *  뷰에서 빈 문자열 아닌지 검증하는 로직을 Parser로 이동 ([b30adc2e](https://github.com/Fiddich-Dev/java-lotto-8/commit/b30adc2e1d7dfd18c71432f5c5e8beec6566b10c))
  *  parser는 입력값을 다른 자료형으로 바꾸는 역할만 수행 ([2345341c](https://github.com/Fiddich-Dev/java-lotto-8/commit/2345341cbcc4fd139c3e331f56f49fca46548078))
* **LottoRank:**
  *  rank를 반환하는 메서드가 불변 객체를 반환하도록 변경 ([48a50d81](https://github.com/Fiddich-Dev/java-lotto-8/commit/48a50d81059200c3d7fdf9dba2e92ce37fc2d6a2))
  *  상금 자료형 int에서 long으로 변경 ([92fce864](https://github.com/Fiddich-Dev/java-lotto-8/commit/92fce864918039d7d42034dbf28b4ec064bc04be))
* **LottoResult:**  checker에서 result로 객체 이름 변경 ([13499985](https://github.com/Fiddich-Dev/java-lotto-8/commit/134999856ef229aaeb36760b6e0154506bbf2d08))
* **WinningLotto:**  당첨번호 객체를 Lotto를 상속받아서 구현 ([4771ceda](https://github.com/Fiddich-Dev/java-lotto-8/commit/4771cedabf99c6a72e99373caa119ba1e21f236d))
* **LottoStore:**  받는 금액의 자료형을 범위가 더 큰 BigInteger로 변경 ([a2eb826a](https://github.com/Fiddich-Dev/java-lotto-8/commit/a2eb826ace21efbc94712d9c97193490d5d49db8))
* **InputView:**  사용하지 않는 중간변수 제거 ([359136d2](https://github.com/Fiddich-Dev/java-lotto-8/commit/359136d2649a3b2a26094e05cbce83fc90236b5c))
* **lotto:**  로또 당첨결과를 열거형으로 변경 ([a37abb9e](https://github.com/Fiddich-Dev/java-lotto-8/commit/a37abb9ed864db2d69b05b1019b4cec2d2f80b4f))

##### Tests

*  뷰를 제외한 모든 객체 테스트 코드 작성 완료 ([6f38534d](https://github.com/Fiddich-Dev/java-lotto-8/commit/6f38534dbe4e129d6dfbc8aaf06cb909cf8dca7d))
*  PutchaseResult 테스트 작성 ([c4a78038](https://github.com/Fiddich-Dev/java-lotto-8/commit/c4a78038cbf18231adf8690b1eb29d75ac7caa0c))
* **lotto:**  로또, 당첨 로또 객체 테스트 작성 ([0f38483e](https://github.com/Fiddich-Dev/java-lotto-8/commit/0f38483e0e5c7341c8c2b915c39e6676f7e5d943))

