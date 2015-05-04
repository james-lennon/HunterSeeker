package com.compsci.hunterseeker.ai;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.learning.error.MeanSquaredError;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;

import com.compsci.hunterseeker.items.Item;

public class BrainController implements ItemController {

	NeuralNetwork xnet;
	private MultiLayerPerceptron ynet;

	public BrainController() {
	}
	
	private MultiLayerPerceptron learnAxis(DataSet data){
		MultiLayerPerceptron network = new MultiLayerPerceptron(2, 30, 30, 2);
//		network.learn(data.getDataSet());
		
		BackPropagation train = new BackPropagation();
		train.setNeuralNetwork(network);
//		train.setUseDynamicMomentum(true);
		network.setLearningRule(train);

		train.setTrainingSet(data);
		train.setErrorFunction(new MeanSquaredError(data.size()));
		
		int epoch = 1;
		do {
			train.doLearningEpoch(data);
			if (epoch > 5) {
				System.out.println("Epoch " + epoch + ", error="
						+ train.getTotalNetworkError());
			}
			epoch++;
		} while (train.getTotalNetworkError() > 0.01 && epoch<100000);
		return network;
	}

	public void learn(GameData data) {
		
	}

	@Override
	public void update(Item i) {
		
		xnet.calculate();
	}
	
	public void load(String filename){
		xnet = NeuralNetwork.createFromFile(filename);
	}

}
