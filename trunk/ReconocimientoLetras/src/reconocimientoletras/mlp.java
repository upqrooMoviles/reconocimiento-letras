/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocimientoletras;


import java.util.Arrays;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.learning.SupervisedTrainingElement;
import org.neuroph.core.learning.TrainingElement;
import org.neuroph.core.learning.TrainingSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.util.TransferFunctionType;



/**
 *
 * @author INGENIERIA
 */
public class mlp {
    
    public static void main(String[] args) {

        TrainingSet trainingSet = new TrainingSet(49, 5);
        /**trainingSet.addElement(new SupervisedTrainingElement(new double[]{0,0,0,1,0,0,0, //LETRA A
                                                                          0,0,1,0,1,0,0,
                                                                          0,1,0,0,0,1,0,
                                                                          1,0,0,0,0,0,1,
                                                                          1,1,1,1,1,1,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1}, new double[]{0,0,0,0,0}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,1,1,1,1,1,0, //LETRA B
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,1,1,1,1,1,0,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,1,1,1,1,1,0}, new double[]{0,0,0,0,1}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,1,1,1,1,1,1, //LETRA C
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,0,0,0,1,
                                                                          1,1,1,1,1,1,1}, new double[]{0,0,0,1,0}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,1,1,1,1,1,0, //LETRA D
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,1,1,1,1,1,0}, new double[]{0,0,0,1,1}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,1,1,1,1,1,1, //LETRA E
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,0,0,0,0,
                                                                          1,1,1,1,1,1,1,
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,0,0,0,0,
                                                                          1,1,1,1,1,1,1}, new double[]{0,0,1,0,0}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,1,1,1,1,1,1, //LETRA F
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,0,0,0,0,
                                                                          1,1,1,1,1,0,0,
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,0,0,0,0}, new double[]{0,0,1,0,1}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,1,1,1,1,1,1, //LETRA G
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,1,1,1,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,1,1,1,1,1,1}, new double[]{0,0,1,1,0}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,0,0,0,0,0,1, //LETRA H
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,1,1,1,1,1,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1}, new double[]{0,0,1,1,1}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,1,1,1,1,1,1, //LETRA I
                                                                          0,0,0,1,0,0,0,
                                                                          0,0,0,1,0,0,0,
                                                                          0,0,0,1,0,0,0,
                                                                          0,0,0,1,0,0,0,
                                                                          0,0,0,1,0,0,0,
                                                                          1,1,1,1,1,1,1}, new double[]{0,1,0,0,0}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{0,1,1,1,1,1,1, //LETRA J
                                                                          0,0,0,0,1,0,0,
                                                                          0,0,0,0,1,0,0,
                                                                          0,0,0,0,1,0,0,
                                                                          0,0,0,0,1,0,0,
                                                                          1,0,0,0,1,0,0,
                                                                          0,1,1,1,0,0,0}, new double[]{0,1,0,0,1}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,0,0,0,0,1,0, //LETRA K
                                                                          1,0,0,0,1,0,0,
                                                                          1,0,0,1,0,0,0,
                                                                          1,0,1,1,0,0,0,
                                                                          1,1,0,0,1,0,0,
                                                                          1,0,0,0,0,1,0,
                                                                          1,0,0,0,0,0,1}, new double[]{0,1,0,1,0}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,1,0,0,0,0,0, //LETRA L
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,0,0,0,1,
                                                                          1,1,1,1,1,1,1}, new double[]{0,1,0,1,1}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,0,0,0,0,0,1, //LETRA M
                                                                          1,1,0,0,0,1,1,
                                                                          1,0,1,0,1,0,1,
                                                                          1,0,0,1,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1}, new double[]{0,1,1,0,0}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,0,0,0,0,0,1, //LETRA N
                                                                          1,1,0,0,0,0,1,
                                                                          1,0,1,0,0,0,1,
                                                                          1,0,0,1,0,0,1,
                                                                          1,0,0,0,1,0,1,
                                                                          1,0,0,0,0,1,1,
                                                                          1,0,0,0,0,0,1}, new double[]{0,1,1,0,1}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{0,1,1,1,1,0,0, //LETRA O
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          0,1,1,1,1,1,0}, new double[]{0,1,1,1,0}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,1,1,1,1,1,0, //LETRA P
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,1,1,1,1,1,0,
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,0,0,0,0}, new double[]{0,1,1,1,1}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{0,1,1,1,1,1,0, //LETRA Q
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,1,0,
                                                                          0,1,1,1,1,0,1}, new double[]{1,0,0,0,0}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,1,1,1,1,1,0, //LETRA R
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,1,1,1,1,1,0,
                                                                          1,0,0,0,1,0,0,
                                                                          1,0,0,0,0,1,0,
                                                                          1,0,0,0,0,0,1}, new double[]{1,0,0,0,1}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{0,1,1,1,1,1,1, //LETRA S
                                                                          1,0,0,0,0,0,0,
                                                                          1,0,0,0,0,0,0,
                                                                          0,1,1,1,1,1,0,
                                                                          0,0,0,0,0,0,1,
                                                                          0,0,0,0,0,0,1,
                                                                          1,1,1,1,1,1,0}, new double[]{1,0,0,1,0}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,1,1,1,1,1,1, //LETRA T
                                                                          0,0,0,1,0,0,0,
                                                                          0,0,0,1,0,0,0,
                                                                          0,0,0,1,0,0,0,
                                                                          0,0,0,1,0,0,0,
                                                                          0,0,0,1,0,0,0,
                                                                          0,0,0,1,0,0,0}, new double[]{1,0,0,1,1}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,0,0,0,0,0,1, //LETRA U
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          0,1,1,1,1,1,0}, new double[]{1,0,1,0,0}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,0,0,0,0,0,1, //LETRA V
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          0,1,0,0,0,1,0,
                                                                          0,0,1,0,1,0,0,
                                                                          0,0,0,1,0,0,0}, new double[]{1,0,1,0,1}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,0,0,0,0,0,1, //LETRA W
                                                                          1,0,0,0,0,0,1,
                                                                          1,0,0,0,0,0,1,
                                                                          0,1,0,0,0,1,0,
                                                                          0,1,0,0,0,1,0,
                                                                          0,1,0,1,0,1,0,
                                                                          0,0,1,0,1,0,0}, new double[]{1,0,1,1,0}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,0,0,0,0,0,1, //LETRA X
                                                                          0,1,0,0,0,1,0,
                                                                          0,0,1,0,1,0,0,
                                                                          0,0,0,1,0,0,0,
                                                                          0,0,1,0,1,0,0,
                                                                          0,1,0,0,0,1,0,
                                                                          1,0,0,0,0,0,1}, new double[]{1,0,1,1,1}));*/
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,0,0,0,0,0,1, //LETRA Y
                                                                          0,1,0,0,0,1,0,
                                                                          0,0,1,0,1,0,0,
                                                                          0,0,0,1,0,0,0,
                                                                          0,0,0,1,0,0,0,
                                                                          0,0,0,1,0,0,0,
                                                                          0,0,0,1,0,0,0}, new double[]{1,1,0,0,0}));
        trainingSet.addElement(new SupervisedTrainingElement(new double[]{1,1,1,1,1,1,1, //LETRA Z
                                                                          0,0,0,0,0,1,0,
                                                                          0,0,0,0,1,0,0,
                                                                          0,0,0,1,0,0,0,
                                                                          0,0,1,0,0,0,0,
                                                                          0,1,0,0,0,0,0,
                                                                          1,1,1,1,1,1,1}, new double[]{1,1,0,0,1}));
        System.out.print("Comienza");
        // create multi layer perceptron
        MultiLayerPerceptron myMlPerceptron = new MultiLayerPerceptron(TransferFunctionType.SGN, 49, 50, 5);
        // learn the training set
        myMlPerceptron.learnInSameThread(trainingSet);

        // test perceptron
        System.out.println("Testing trained neural network");
        //testNeuralNetwork(myMlPerceptron, trainingSet);

        // save trained neural network
        myMlPerceptron.save("myMlPerceptron.nnet");

        // load saved neural network
        NeuralNetwork loadedMlPerceptron = NeuralNetwork.load("myMlPerceptron.nnet");

        // test loaded neural network
        System.out.println("Testing loaded neural network");
        double tes[]={1,1,1,1,1,1,1, //LETRA Z
                                                                          0,0,0,0,0,1,0,
                                                                          0,0,0,0,1,0,0,
                                                                          0,0,0,1,0,0,0,
                                                                          0,0,1,0,0,0,0,
                                                                          0,1,0,0,0,0,0,
                                                                          1,1,1,1,1,1,1};
        double res[]=testNeuralNetwork(loadedMlPerceptron, tes);
        if (res[0]==0 && res[1]==0 && res[2]==0 && res[3]==0 && res[4]==0){System.out.println("LETRA A");}
        if (res[0]==0 && res[1]==0 && res[2]==0 && res[3]==0 && res[4]==1){System.out.println("LETRA B");}
        if (res[0]==0 && res[1]==0 && res[2]==0 && res[3]==1 && res[4]==0){System.out.println("LETRA C");}
        if (res[0]==0 && res[1]==0 && res[2]==0 && res[3]==1 && res[4]==1){System.out.println("LETRA D");}
        if (res[0]==0 && res[1]==0 && res[2]==1 && res[3]==0 && res[4]==0){System.out.println("LETRA E");}
        if (res[0]==0 && res[1]==0 && res[2]==1 && res[3]==0 && res[4]==1){System.out.println("LETRA F");}
        if (res[0]==0 && res[1]==0 && res[2]==1 && res[3]==1 && res[4]==0){System.out.println("LETRA G");}
        if (res[0]==0 && res[1]==0 && res[2]==1 && res[3]==1 && res[4]==1){System.out.println("LETRA H");}
        if (res[0]==0 && res[1]==1 && res[2]==0 && res[3]==0 && res[4]==0){System.out.println("LETRA I");}
        if (res[0]==0 && res[1]==1 && res[2]==0 && res[3]==0 && res[4]==1){System.out.println("LETRA J");}
        if (res[0]==0 && res[1]==1 && res[2]==0 && res[3]==1 && res[4]==0){System.out.println("LETRA K");}
        if (res[0]==0 && res[1]==1 && res[2]==0 && res[3]==1 && res[4]==1){System.out.println("LETRA L");}
        if (res[0]==0 && res[1]==1 && res[2]==1 && res[3]==0 && res[4]==0){System.out.println("LETRA M");}
        if (res[0]==0 && res[1]==1 && res[2]==1 && res[3]==0 && res[4]==1){System.out.println("LETRA N");}
        if (res[0]==0 && res[1]==1 && res[2]==1 && res[3]==1 && res[4]==0){System.out.println("LETRA O");}
        if (res[0]==0 && res[1]==1 && res[2]==1 && res[3]==1 && res[4]==1){System.out.println("LETRA P");}
        if (res[0]==1 && res[1]==0 && res[2]==0 && res[3]==0 && res[4]==0){System.out.println("LETRA Q");}
        if (res[0]==1 && res[1]==0 && res[2]==0 && res[3]==0 && res[4]==1){System.out.println("LETRA R");}
        if (res[0]==1 && res[1]==0 && res[2]==0 && res[3]==1 && res[4]==1){System.out.println("LETRA T");}
        if (res[0]==1 && res[1]==0 && res[2]==1 && res[3]==0 && res[4]==0){System.out.println("LETRA U");}
        if (res[0]==1 && res[1]==0 && res[2]==1 && res[3]==0 && res[4]==1){System.out.println("LETRA V");}
        if (res[0]==1 && res[1]==0 && res[2]==1 && res[3]==1 && res[4]==0){System.out.println("LETRA W");}
        if (res[0]==1 && res[1]==0 && res[2]==1 && res[3]==1 && res[4]==1){System.out.println("LETRA X");}
        if (res[0]==1 && res[1]==1 && res[2]==0 && res[3]==0 && res[4]==0){System.out.println("LETRA Y");}
        if (res[0]==1 && res[1]==1 && res[2]==0 && res[3]==0 && res[4]==1){System.out.println("LETRA Z");}
        System.out.println(res[0]);
        System.out.println(res[1]);
        System.out.println(res[2]);
        System.out.println(res[3]);
        System.out.println(res[4]);
    }      
    
    public static double[] testNeuralNetwork(NeuralNetwork neuralNet, double[] entrada) {
        double aux[]=new double[5];
        
            neuralNet.setInput(entrada);
            neuralNet.calculate();
            double[] networkOutput = neuralNet.getOutput();
            //System.out.print("Input: " + Arrays.toString(entrada) );
            //System.out.println(" Output: " + Arrays.toString(networkOutput) );            
            for (int cont=0; cont<5; cont++)
            {
                if (networkOutput[cont]>0.5)
                {
                    aux[cont]=1;
                }else
                {
                    aux[cont]=0;
                }
            }            
        
        return aux;
    }
}
