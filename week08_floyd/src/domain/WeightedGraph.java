package domain;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

    public WeightedGraph(double[][] matrix) {
        if (!isGeldigeGewichtenmatrix(matrix))
            throw new IllegalArgumentException("No valid gewichtenmatrix");
        this.gewichtenMatrix = matrix;
    }

    private boolean isGeldigeGewichtenmatrix(double[][] matrix) {
        return matrix != null && matrix.length == matrix[0].length;
    }

    private int getAantalKnopen() {
        return gewichtenMatrix.length;
    }

    public int[][] getPointerMatrix() {
        int[][] pointerMatrix = new int[getAantalKnopen()][getAantalKnopen()];
        double[][] DMatrix = this.gewichtenMatrix.clone();
        for(int rij = 0;rij < getAantalKnopen();rij++){ //om shallow copy te vermijden
            DMatrix[rij] = DMatrix[rij].clone();
        }
        for(int tussenstation = 0;tussenstation < getAantalKnopen();tussenstation++){
            for(int rij = 0;rij < getAantalKnopen();rij++){
                for(int kolom = 0;kolom < getAantalKnopen();kolom++){
                    if(DMatrix[rij][tussenstation] + DMatrix[tussenstation][kolom] < DMatrix[rij][kolom]){
                        DMatrix[rij][kolom] = DMatrix[rij][tussenstation] + DMatrix[tussenstation][kolom];
                        pointerMatrix[rij][kolom] = tussenstation + 1; //+1 omdat index niet hetzelfde is als tussenstation
                    }
                }
            }
        }
		return pointerMatrix;
	}

	public List<Integer> getShortestPath(int van, int tot, int[][] pointer) {
		List<Integer> res = new ArrayList<>();
		if(van == tot){
		    return res;
        } else{
		    int via = pointer[van-1][tot-1];
		    if(via == 0){
		        res.add(van);
		        res.add(tot);
            } else{
		        res = getShortestPath(van, via, pointer);
		        res.remove(res.size()-1); //anders dubbel
		        res.addAll(getShortestPath(via, tot, pointer));
            }
        }
		return res;

	}

	public int berekenLengte(List<Integer> pad) {
		int som = 0;
		for(int i = 0;i < pad.size() - 1;i++){
		    som += this.gewichtenMatrix[pad.get(i)-1][pad.get(i+1)-1];
        }
		return som;
	}
}
