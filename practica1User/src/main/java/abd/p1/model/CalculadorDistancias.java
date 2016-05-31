package abd.p1.model;


public class CalculadorDistancias {
	public static double calculaDistanca(double la1, double long1, double la2, double long2){
		double latitud1 = Math.toRadians(la1);
		double longitud1 = Math.toRadians(long1);
		double latitud2 = Math.toRadians(la2);
		double longitud2 = Math.toRadians(long2);
		int R = 6371;
		
		Double latDistance = latitud2-latitud1;
        Double lonDistance = longitud2-longitud1;
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
                   Math.cos(latitud1) * Math.cos((latitud2)) * 
                   Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distance = R * c;
		return distance;
	}
}
