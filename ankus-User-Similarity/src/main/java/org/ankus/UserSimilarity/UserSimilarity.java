package org.ankus.UserSimilarity;

import org.ankus.mapreduce.algorithms.recommendation.similarity.cfbased.CFBasedSimilarityDriver;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class UserSimilarity 
{
    @SuppressWarnings("unused")
	public static void main( String[] args )
    {
    	CFBasedSimilarityDriver User_similarity = new CFBasedSimilarityDriver();
    	
    	try
    	{
    		/**
    		 * 하둡의 마스터 노드의 호스트명 혹은 IP주소를 기입한다.
    		 **/
	    	String master = "localhost";
	    	/**
	    	 * 사용자::아이템::평점(선호도)로 구성된 아이템 선호도 테이블 파일
	    	 **/
	    	String input_data_path="/user/demo/data/CF_Similarity/ratings_double_colon.txt";
	    	/**
	    	 * 사용자간 유사도가 저장될 파일
	    	 **/
	    	String result_path="/user/demo/data/CF_Similarity_result";
	    	/**
	    	 * 선호도 테이블 파일에서 각 항목(사용자, 아이템, 평점)을 구분할 수 있는 구분자
	    	 **/
	    	String delimiter="::";
	    	/**
	    	 * 선호도 테이블에서 사용자 항목 인덱스
	    	 **/
	    	String userIndex="0";
	    	/**
	    	 * 선호도 테이블에서 아이템 항목 인덱스
	    	 **/
	    	String itemIndex="1";
	    	/**
	    	 * 선호도 테이블에서 평점 항목 인덱스
	    	 **/
	    	String rateIndex="2";
	    	/**
	    	 * 추천 알고리즘을 수행하기 위한 모델 생성 방식으로 사용자(user)와 아이템(item)이 있으나
	    	 * 여기서는 사용자로 설정하기 위해 user로 설정한다.
	    	 **/
	    	String method= "user";
	    	/**
	    	 * 사용자간 유사성 계산을 위해 서로 다른 사용자가 함께 평가한 아이템의 갯수 
	    	 **/
	    	String commonCount="20";
	    	/**
	    	 * 유사도 계산 방법을 설정
	    	 * uclidean,cosine,pearson을 지원한다
	    	 **/
	    	String distance_measure="pearson";
	    	/**
	    	 * 모든 데이터 노드가 하둡 환경 변수를 참조하여 알고리즘을 수행 할 수 있도록 
	    	 * 하둡 환경 변수에 알고리즘 수행 변수를 추가 설정한다.
	    	 * 추가된 변수는 Configuration 변수에 설정되어 리턴된다.
	    	 **/
	    	Configuration conf = User_similarity.Similarity_Configuration(master, input_data_path, result_path, delimiter, userIndex, itemIndex, rateIndex, method, commonCount, distance_measure);
	    	/**
	    	 * 설정된 환경 변수를 토대로 아이템 평점 기반 사용간 유사도를 산출한다.
	    	 * 정상적으로 계산이 완료되면 0,오류 발생시 1이 리턴된다.
	    	 */
	    	int rtn = User_similarity.Similarity_MRJob(conf);
	    	if(rtn == 0){
	    		System.out.println("Success");	    		
	    	}
	    	else
	    	{
	    		System.out.println("Faile");
	    	}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.toString());
    	}
    }
}
