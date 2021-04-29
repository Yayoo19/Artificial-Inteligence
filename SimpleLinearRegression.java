public class SimpleLinearRegression {
	static double[] year = new double[] {1,2,3,4,5,6,7,8,9};
    static double[] adv = new double[] {23,26,30,34,43,48,52,57,58};
    double beta_1,beta_0,x2;
	double prediction = 0;

	//Constructores
	public SimpleLinearRegression(double b1, double b0){
		this.beta_1 = b1;
		this.beta_0 = b0;
	}
	public SimpleLinearRegression(){
		
	}
	public SimpleLinearRegression(double x){
		this.x2=x;
	}

	public void LR(){
		int n;
		double sum_x=0,sum_y=0,sum_xy=0,sum_x2=0;
		
		n=year.length;
		for(int i=0; i < n; i++) {

			sum_x=+ year[i];
			sum_y =+ adv[i];
			sum_xy= sum_xy + year[i]*adv[i];
			sum_x2= sum_x2 + year[i]*year[i];
		}

		SimpleLinearRegression dt= new SimpleLinearRegression();
		dt.calculation(sum_x, sum_y, sum_xy, sum_x2, n, x2);
	}

    public void calculation(double SUMX,double SUMY,double SUMXY,double SUMX2, int n, double x) {

		beta_1 = ( n * SUMXY - SUMX * SUMY) / ( n * SUMX2 - SUMX * SUMX );
		beta_0 = ( SUMY * SUMX2 - SUMX * SUMXY ) / ( n * SUMX2 - SUMX * SUMX );
		result(beta_0,beta_1);
		prediction = beta_0 + beta_1 * x;
		System.out.println("\n" + prediction);
	}

	public void result(double beta_0,double beta_1) {

		System.out.println("Y = B0 + B1 + X");
		System.out.println("Y = "+beta_0+" + "+beta_1+" + "+x2);
	}
}