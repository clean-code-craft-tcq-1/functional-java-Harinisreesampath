package vitals;


public class BatteryManagement {
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
    		return (temperatureCheck(temperature) && chargeStateCheck(soc) && chargeRateCheck(chargeRate));    	   	
    }

    static boolean temperatureCheck(float temperature) {
    	if(temperature <0) {
    		 System.out.println("Temperature " +  temperature + " is low");
    		 return false;
    	}   		
    	if(temperature > 45) {
    		System.out.println("Temperature " +  temperature + " is high");
    		 return false;
    	}
    	 return true;
    }
    
    static boolean chargeStateCheck(float soc) {
    	if(soc < 20) {
    		System.out.println("State of Charge "+ soc + " is low");
    		return false;
    	}   		
    	if(soc > 80) {
    		System.out.println("State of Charge "+ soc + " is high");
    		return false;
    	}
    	 return true;
    }
    
    static boolean chargeRateCheck(float chargeRate) {
    	if(chargeRate > 0.8) {
    		System.out.println("Charge Rate "+ chargeRate + " is high");
    		return false;
    	}
    	 return true;
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
