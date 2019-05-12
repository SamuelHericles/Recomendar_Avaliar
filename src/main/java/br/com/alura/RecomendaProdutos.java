package br.com.alura;

import java.io.File;		
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class RecomendaProdutos {
	public static void main(String[] args) throws IOException, TasteException {
		//Carregar o arquivo csv
		File file =  new File("cursos2.csv");
	
		/*
		 * Na tabela deve ter
		 * primeira coluna: o numero do usuario
		 * segunda coluna: o tipo de filme ou outra coisa
		 * tercerira coluna: a nota que ele deu
		 * 
		 * */
		//Cuide da escalas de avaliacao!!!!
		//Anote sua descicoes!!!!
		//Cuidado com retirar alguns do grupo!!!
		//Use recomendacoes para algo util!!!
		
		//-> Criar o modelo
		//Classe para modelar arquivos de Data Model
		DataModel model = new FileDataModel(file);
		
		//Comparador de similaridade de usuarios,Taste=gosto, quem eh vizinho de quem
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		
		
		//->Criar função de proximidade e similaridade
		//Método para verificar as semelhanças na vizinhanças
		UserNeighborhood neighboorhood = new ThresholdUserNeighborhood(0.1, similarity, model);
		
		//Método para dar as recomendacoes aos usuarios
		GenericUserBasedRecommender recommeder = new GenericUserBasedRecommender(model, neighboorhood, similarity);
		 
		
		//->Sair dando recomendacao
		
		List<RecommendedItem> recommendations = recommeder.recommend(1,30);
		for(RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
		
		recommendations = recommeder.recommend(10,10);
		for(RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}

		recommendations = recommeder.recommend(4,10);
		for(RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
		
		
		
	}
}
