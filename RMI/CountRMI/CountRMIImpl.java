public class CountRMIImpl implements CountRMI   
{
	private int sum = 0;
   public int getSum() {
		return sum;
	}
	public void setSum(int val) {
		sum = val;
	}

	public int increase(int val) {
		sum += val;
		return sum;
	}
	
}
