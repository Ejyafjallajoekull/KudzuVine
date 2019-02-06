package kudzu.vine.math.matrix;

import java.util.Arrays;
import java.util.Objects;

public class ArrayMatrix implements Matrix {

	private final double[][] content;
	private final int rows;
	private final int columns;
	
	public ArrayMatrix(int m, int n) {
		if (m < 0 || n < 0) {
			throw new IllegalArgumentException(String.format(
					"Matrix row (%d) and column (%d) size may not be negative.", m, n));
		}
		this.content = new double[m][n];
		this.rows = this.content.length;
		if (this.content.length > 0) {
			this.columns =  this.content[0].length;
		} else {
			this.columns = 0;
		}
	}
	
	public ArrayMatrix(double[][] matrixContent) {
		this.content = Objects.requireNonNull(matrixContent).clone();
		this.rows = this.content.length;
		if (this.content.length > 0) {
			this.columns =  this.content[0].length;
		} else {
			this.columns = 0;
		}
	}
	
	@Override
	public int getRowSize() {
		return this.rows;
	}

	@Override
	public int getColumnSize() {
		return this.columns;
	}

	@Override
	public double get(int m, int n) {
		return this.content[m][n];
	}

	@Override
	public boolean isSymmetric() {
		if (!this.isQuadratic()) {
			return false;
		}
		for (int m = 0; m < this.rows; m++) {
			for (int n = m+1; n < this.columns; n++) {
				if (Double.compare(this.content[m][n], this.content[n][m]) != 0) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean isQuadratic() {
		return this.columns == this.rows;
	}

	@Override
	public Matrix transponate() {
		ArrayMatrix transponate = new ArrayMatrix(this.columns, this.rows);
		for (int m = 0; m < this.rows; m++) {
			for (int n = 0; n < this.columns; n++) {
				transponate.content[n][m] = this.content[m][n];
			}
		}
		return transponate;
	}

	@Override
	public Matrix multiply(double multiplicand) {
		ArrayMatrix multipliedMatrix = new ArrayMatrix(this.content);
		for (int m = 0; m < this.rows; m++) {
			for (int n = 0; n < this.columns; n++) {
				multipliedMatrix.content[m][n] = multipliedMatrix.content[m][n] * multiplicand;
			}
		}
		return multipliedMatrix;
	}

	@Override
	public Matrix multiply(Matrix multiplicand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix divide(double divisor) {
		ArrayMatrix dividedMatrix = new ArrayMatrix(this.content);
		for (int m = 0; m < this.rows; m++) {
			for (int n = 0; n < this.columns; n++) {
				dividedMatrix.content[m][n] = dividedMatrix.content[m][n] / divisor;
			}
		}
		return dividedMatrix;
	}

	@Override
	public Matrix divide(Matrix divisor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix add(Matrix addend) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix inverse() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(String.format("[%n"));
		for (double[] row : this.content) {
			sb.append(String.format("%s%n", Arrays.toString(row)));
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public double[] getRow(int m) {
		return this.content[m];
	}

	@Override
	public double[] getColumn(int n) {
		double[] column = new double[this.rows];
		for (int rowIndex = 0; rowIndex < this.rows; rowIndex++) {
			column[rowIndex] = this.content[rowIndex][n];
		}
		return column;
	}

	@Override
	public double[][] to2DArray() {
		return this.content.clone();
	}

	@Override
	public Matrix subtract(Matrix subtrahend) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[] getMainDiagonal() {
		int length = this.rows > this.columns ? this.columns : this.rows;
		double[] diagonal = new double[length];
		for (int columnRow = 0; 
				columnRow < this.rows && columnRow < this.columns; 
				columnRow++) {
			diagonal[columnRow] = this.content[columnRow][columnRow];
		}
		return diagonal;
	}

	@Override
	public double[] getAntiDiagonal() {
		int length = this.rows > this.columns ? this.columns : this.rows;
		double[] diagonal = new double[length];
		for (int columnRow = 0; 
				columnRow < this.rows && columnRow < this.columns; 
				columnRow++) {
			diagonal[columnRow] = this.content[columnRow][this.columns - 1 - columnRow];
		}
		return diagonal;
	}

	@Override
	public double trace() {
		if (this.isQuadratic()) {
			return Arrays.stream(this.getMainDiagonal()).sum();
		} else {
			throw new ArithmeticException("The trace can only be calculated for quadratic matrices.");
		}
	}

	@Override
	public boolean isRegular() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
