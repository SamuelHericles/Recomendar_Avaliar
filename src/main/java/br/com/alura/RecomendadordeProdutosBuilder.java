package br.com.alura;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class RecomendadordeProdutosBuilder implements RecommenderBuilder {

	public Recommender buildRecommender(DataModel model) throws TasteException {
		
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		UserNeighborhood neighboorhood = new ThresholdUserNeighborhood(0.1, similarity, model);
		GenericUserBasedRecommender recommeder = new GenericUserBasedRecommender(model, neighboorhood, similarity);
		
		return recommeder;
	}

}
