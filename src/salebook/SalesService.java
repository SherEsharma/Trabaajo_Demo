package salebook;



public class SalesService {
public boolean cheak_Sales_Detail(SalesDto sdto)
{ 
		SalesDao s=new SalesDao();
	s.insert_sales_Details( sdto);
	return false;
	
}

	
}

