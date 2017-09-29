수치/범주형 데이터에 대해 유클리드/멘허튼 거리 측정 방법을 이용하여 가까운 것끼리 묶어주는
군집 알고리즘입니다.

수행 방법:
hadoop jar ankus-core2-boolean-sim-1.1.0.jar BooleanDataCorrelation \
-input 입력 데이터 파일 \
-output 출력 데이터 폴더 \
-delimiter 속성간 구분자  \
-keyIndex 데이터 식별자를 위한 기준 키(Unique key)가 되는 컬럼 \
-algorithmOption 유사도/거리 계산 옵션 선택(dice coefficient,jaccard coefficient, hamming distance)

boolean similarity 실행 예제.
hadoop jar ankus-core2-boolean-sim-1.1.0.jar BooleanDataCorrelation \
-input /user/whitepoo/boolean_sim.tsv \
-output /user/whitepoo/boolean_sim_result \
-delimiter ' ' \
-keyIndex 0 \
-algorithmOption jaccard