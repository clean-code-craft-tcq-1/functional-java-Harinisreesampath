package vitals;


public class Main {
	public static final float LOWER_TEMPERATURE = 0;
	public static final float HIGHER_TEMPERATURE = 45;
	public static final float LOWER_SOC = 20;
	public static final float HIGHER_SOC = 80;
	public static final float HIGHER_CHARGERATE = 0.8f;
	public static final String MEASUREMENT_TEMPERATURE = "TEMPERATURE";
	
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
    	int temperatureStatus = temperatureCheck(temperature, LOWER_TEMPERATURE, HIGHER_TEMPERATURE);
    	int socStatus = chargeStateCheck(soc, LOWER_SOC, HIGHER_SOC);
    	int chargeRateStatus = chargeRateCheck(chargeRate,HIGHER_CHARGERATE);
    	
    	printMessage(processMessage(temperatureStatus),"TEMPERATURE");
    	printMessage(processMessage(socStatus),"Charge State");
    	printMessage(processMessage(chargeRateStatus),"Charge Rate");
    	
    	if((temperatureStatus + socStatus + chargeRateStatus) > 0) {
    		return false;
    	}
    	else 
    		return true;
    	
    }

    static int temperatureCheck(float temperature, float lowerLimit, float higherLimit) {
    	if(temperature <lowerLimit) {
    		 return 1;
    	}   		
    	if(temperature > higherLimit) {
    		 return 2;
    	}
    	 return 0;
    }
    
    static int chargeStateCheck(float soc, float lowerLimit, float higherLimit) {
    	if(soc < lowerLimit) {
    		return 1;
    	}   		
    	if(soc > higherLimit) {
    		return 2;
    	}
    	 return 0;
    }
    
    static int chargeRateCheck(float chargeRate, float higherLimit) {
    	if(chargeRate > higherLimit) {
    		return 1;
    	}
    	 return 0;
    }
    
    static String processMessage(int measurementCode) {
    	if(measurementCode == 1)
    		return "Low";
    	if(measurementCode == 2)
    		return "High";   

    		return "Normal";
    }
    
    static void printMessage(String message, String type) {
    	System.out.println(type + " : " +message);
    }
    
    public static void main(String[] args) {
    	assert(batteryIsOk(25, 70, 0.7f) == true);
    	assert(batteryIsOk(50, 85, 0.0f) == false);
    	assert(batteryIsOk(25,10,0.7f) == false);
    	assert(batteryIsOk(25,70,1.0f) == false);
    	assert(batteryIsOk(-25,10,0.7f) == false);    	
    	assert(batteryIsOk(25,70,1) == false);
        System.out.println("Some more tests needed");
    }
}