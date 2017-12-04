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
	    	String master = "localhost";
	    	String input_data_path="/user/demo/data/CF_Similarity/ratings_double_colon.txt";
	    	String result_path="/user/demo/data/CF_Similarity_result";
	    	String delimiter="::";
	    	String userIndex="0";
	    	String itemIndex="1";
	    	String rateIndex="2";
	    	String method= "user";
	    	String commonCount="20";
	    	String distance_measure="pearson";
	    	
	    	Configuration conf = User_similarity.Similarity_Configuration(master, input_data_path, result_path, delimiter, userIndex, itemIndex, rateIndex, method, commonCount, distance_measure);
	    	
	    	int rtn = User_similarity.Similarity_MRJob(conf);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.toString());
    	}
    }
}
