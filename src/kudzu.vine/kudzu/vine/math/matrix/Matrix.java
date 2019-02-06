package kudzu.vine.math.matrix;

import java.util.Objects;

public interface Matrix {

	public int getRowSize();
	
	public int getColumnSize();
		
	public double get(int m, int n);
	
	public double[] getRow(int m);
	
	public double[] getColumn(int n);
	
	public double[] getMainDiagonal();
	
	public double[] getAntiDiagonal();
	
	/**
	 * Calculate the trace of a matrix.
	 * 
	 * <p>The trace is the sum of the main diagonal of a quadratic matrix.</p>
	 * 
	 * @return the trace of the matrix
	 * @throws ArithmeticException if the matrix is not quadratic
	 */
	public double trace();
			
	public boolean isSymmetric();
	
	public boolean isQuadratic();
	
	public Matrix transponate();
	
	/**
	 * Add a matrix of the same dimensions to this matrix.
	 * 
	 * @param addend - the matrix to add
	 * @return the sum of both matrices
	 * @throws ArithmeticException - if the matrices are not of the same dimensions
	 * @throws NullPointerException if the addend is {@code null}
	 */
	public Matrix add(Matrix addend);
	
	/**
	 * Subtract a matrix of the same dimensions from this matrix.
	 * 
	 * @param addend - the matrix to subtract
	 * @return the difference of both matrices
	 * @throws ArithmeticException - if the matrices are not of the same dimensions
	 * @throws NullPointerException if the subtrahend is {@code null}
	 */
	public Matrix subtract(Matrix subtrahend);
	
	public Matrix multiply(double multiplicand);
	
	public Matrix multiply(Matrix multiplicand);
	
	public Matrix divide(double divisor);
	
	public Matrix divide(Matrix divisor);
	
	public boolean isRegular();
	
	public Matrix inverse();
	
	public double[][] to2DArray();
	
	/**
	 * Create a new null matrix of the specified bounds.
	 * 
	 * @param m - number of rows
	 * @param n - number of columns
	 * @return a null matrix with the specified number of rows and columns
	 * @throws IllegalArgumentException if the number of rows or columns is smaller zero
	 */
	public static Matrix createMatrix(int m, int n) {
		if (m < 0 || n < 0) {
			throw new IllegalArgumentException(String.format(
					"Matrix row (%d) and column (%d) size may not be negative.", m, n));
		}
		return new ArrayMatrix(m, n);
	}
	
	/**
	 * Create a copy of the matrix.
	 * 
	 * <p> For a matrix <i>A</i> with <i>m</i> rows and <i>n</i> columns a copy 
	 * <i>B</i> of the same dimensions is returned so that for every element 
	 * <i>a<sub>mn</sub></i> of matrix <i>A</i> and element b<sub>mn</sub></i> of 
	 * matrix <i>B</i> <i>a<sub>mn</sub> = b<sub>mn</sub></i>.</p>
	 * 
	 * <p>However, the following statement is not required to be true: {@code A.equals(B)}</p>
	 * 
	 * @param m - number of rows
	 * @param n - number of columns
	 * @return a null matrix with the specified number of rows and columns
	 * @throws NullPointerException if the specified matrix is {@code null}
	 */
	public static Matrix createMatrix(Matrix matrix) {
		return new ArrayMatrix(Objects.requireNonNull(matrix).to2DArray());
	}
	
	/**
	 * Create a matrix from the specified 2D array.
	 * 
	 * <p> A matrix <i>A</i> with <i>m</i> rows and <i>n</i> columns is created with the 
	 * same dimensions as the specified array {@code matrixContent}.
	 * 
	 * Every element <i>a<sub>mn</sub></i> of matrix <i>A</i> is set to the 
	 * corresponding element in the content array:<br>
	 * <br>
	 * <i>a<sub>mn</sub> = {@code matrixContent[m][n]}</i>.</p>
	 * 
	 * @param matrixContent - the content of the matrix to create
	 * @return a null matrix with the specified content
	 * @throws NullPointerException if the specified matrix content is {@code null}
	 */
	public static Matrix createMatrix(double[][] matrixContent) {
		return new ArrayMatrix(Objects.requireNonNull(matrixContent));
	}
	
}
