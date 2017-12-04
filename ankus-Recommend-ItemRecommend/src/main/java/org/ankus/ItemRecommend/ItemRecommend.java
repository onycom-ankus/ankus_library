package org.ankus.ItemRecommend;

import org.ankus.mapreduce.algorithms.recommendation.recommender.userbased.UserSimRecommenderDriver;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class ItemRecommend 
{
    @SuppressWarnings("unused")
	public static void main( String[] args )
    {
    	UserSimRecommenderDriver ItemRecommend = new UserSimRecommenderDriver();
    	
    	try
    	{
	    	String master = "localhost";
	    	String input="/user/demo/data/CF_Similarity/ratings_double_colon.txt";
	    	String output="/user/demo/data/RecommendResult";
	    	String delimiter="::";
	    	String uidIndex="0";
	    	String iidIndex="1";
	    	String ratingIndex="2";
	    	String similPath = "/user/demo/data/CF_Similarity_result/part-r-00000";
	    	String similDelimiter = "::";
	    	String basedType = "user";
	    	double similThreshold = 0.2;
	    	int recomCnt = 10;
	    	String targetUID = "3053";
	    	
	    	

	    	Configuration conf = ItemRecommend.ItemRecommend_Configuration(master, input, output, delimiter, uidIndex, iidIndex, ratingIndex, similPath, similDelimiter, basedType, similThreshold, recomCnt, targetUID);
	    	
	    	int rtn = ItemRecommend.ItemRecommend_MRJob(conf);
	    	
	    	if(rtn == 1)
	    	{
	    		System.out.println("Failed");
	    	}
	    	else
	    	{
	    		System.out.println("Success");
	    	}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.toString());
    	}
    }
}
