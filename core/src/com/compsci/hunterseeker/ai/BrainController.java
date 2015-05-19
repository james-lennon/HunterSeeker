package com.compsci.hunterseeker.ai;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.events.LearningEvent;
import org.neuroph.core.events.LearningEventListener;
import org.neuroph.core.learning.error.MeanSquaredError;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.nnet.learning.MomentumBackpropagation;

import com.compsci.hunterseeker.items.Item;
import com.compsci.hunterseeker.screens.TrainScreen;
import com.compsci.hunterseeker.util.Globals;

public class BrainController implements ItemController {

	MultiLayerPerceptron net;

	public BrainController() {
		// create new perceptron network
		net = new MultiLayerPerceptron(2, 20, 4);
	}

	public void learn(GameData data) {
		// neuralNetwork.randomizeWeights();
		MomentumBackpropagation train = new MomentumBackpropagation();
		// train.setMomentum(2);
		train.setLearningRate(.2);
		train.setMomentum(.7);
		train.setNeuralNetwork(net);
		// train.setUseDynamicMomentum(true);
		net.setLearningRule(train);

		// create training set
		DataSet trainingSet = data.getDataSet();
		// setupData(trainingSet, 2);
		train.setTrainingSet(trainingSet);
		// train.setErrorFunction(new MeanSquaredError(trainingSet.size()));
		// System.out.println(trainingSet);
		// System.exit(1);
		final long start = System.currentTimeMillis();
		net.getLearningRule().addListener(new LearningEventListener() {

			@Override
			public void handleLearningEvent(LearningEvent event) {
				double e = ((BackPropagation) event.getSource())
						.getPreviousEpochError();
				System.out.println(e);
				if (System.currentTimeMillis() - start > Globals.learnTime * 1000) {
					net.stopLearning();
					((TrainScreen)Globals.game.getScreen()).finishTraining();
				}
			}
		});
		net.learnInNewThread(trainingSet);
	}

	public void setInputs(float dx, float dy) {
		net.setInput(dx, dy);
	}

	private boolean checkThreshold(double val) {
		return val > .2;
	}

	@Override
	public void update(Item i) {
		net.calculate();
		double[] out = net.getOutput();
		float dx = 0, dy = 0;

		if (checkThreshold(out[0])) {
			dx = -1;
		} else if (checkThreshold(out[1])) {
			dx = 1;
		}
		if (checkThreshold(out[2])) {
			dy = -1;
		} else if (checkThreshold(out[3])) {
			dy = 1;
		}

		i.dir.set(dx, dy);
	}

	 public void load(String filename){
		 net = (MultiLayerPerceptron) NeuralNetwork.createFromFile(filename);
	 }

}
