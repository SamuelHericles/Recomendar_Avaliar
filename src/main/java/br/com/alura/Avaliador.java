package br.com.alura;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;

public class Avaliador {
	public static void main(String[] args) throws IOException, TasteException {
		
		//O Mahout usa linhas aleatória para teste e validação e isso não é bom
		//o randomutils prende o mahout, mantendo o primeiro resultado para teste.
		RandomUtils.useTestSeed();//não aleatorizar os dados.
		
		
		//Com o evaluator é pra saber o quão bom é nosso recomendador
		File file = new File("cursos2.csv");
		DataModel model = new FileDataModel(file);
		
		
		//Criar um avaliador e separa 90% pra aprenedr e 10% pra avaliar.
		RecommenderEvaluator evaluator =  new AverageAbsoluteDifferenceRecommenderEvaluator();
		RecommenderBuilder builder = new RecomendadordeProdutosBuilder();
		
		//Margem de erro.
		double error = evaluator.evaluate(builder,null, model,0.9,1.0);
		//A escolha dos dados de teste e avaliaçaõ é dado de forma aletatória
		
		System.out.println(error);
	}
}
