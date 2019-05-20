import java.io.File;
import java.util.*;

public class Recommender {

    public static Clothing recommend(Map w) {
    
        float temperature = Float.parseFloat((String) w.get("Temperature"));
        int weatherDesc = Integer.parseInt((String) w.get("WeatherIcon"));
        
        File accessory;
        // Accessory
        if (StyleGuide.getRain().contains(weatherDesc)) {
            accessory = StyleGuide.getUmbrellaIcon();
        } else if (StyleGuide.getSunny().contains(weatherDesc)) {
            accessory = StyleGuide.getSunglassesIcon();
        } else if (temperature < 5) {
            accessory = StyleGuide.getScarfIcon();
        } else {
            accessory = StyleGuide.getEmptyIcon();
        }

        File top;
        if (StyleGuide.getRain().contains(weatherDesc)) {
            top = StyleGuide.getWaterproofIcon();
        } else if (StyleGuide.getSnow().contains(weatherDesc) || temperature < 5){
            top = StyleGuide.getCoatIcon();
        } else if (temperature < 12) {
            top = StyleGuide.getJacketIcon();
        } else if (temperature < 14) {
            top = StyleGuide.getSweatshirtIcon();
        } else if (temperature < 16) {
            top = StyleGuide.getSweaterIcon();
        } else {
            top = StyleGuide.gettShirtIcon();
        }

        File bottom;
        if (temperature < 16) {
            bottom = StyleGuide.getTrousersIcon();
        } else if (temperature < 25) {
            bottom = StyleGuide.getShortsIcon();
        } else {
            bottom = StyleGuide.getShortShortsIcon();
        }

        File shoes;
        if (StyleGuide.getRain().contains(weatherDesc)) {
            shoes = StyleGuide.getRainBootsIcon();
        } else if (StyleGuide.getSnow().contains(weatherDesc)) {
            shoes = StyleGuide.getSnowBootIcon();
        } else if (temperature < 25) {
            shoes = StyleGuide.getSneakersIcon();
        } else {
            shoes = StyleGuide.getSandalsIcon();
        }

        File main;
        if (StyleGuide.getRain().contains(weatherDesc)) {
            main = StyleGuide.getUmbrellaIcon();
        } else if (StyleGuide.getSunny().contains(weatherDesc)) {
            main = StyleGuide.getSunglassesIcon();
        } else if (StyleGuide.getPartlyCloudy().contains(weatherDesc)){
            main = StyleGuide.getPartlyCloudyIcon();
        } else if (StyleGuide.getCloudy().contains(weatherDesc)){
            main = StyleGuide.getCloudyIcon();
        } else if (StyleGuide.getThunderstorm().contains(weatherDesc)){
            main = StyleGuide.getThunderstormIcon();
        } else if (StyleGuide.getSnow().contains(weatherDesc)){
            main = StyleGuide.getSnowingIcon();
        } else if (StyleGuide.getWind().contains(weatherDesc)){
            main = StyleGuide.getWindyIcon();
        } else {
            main = StyleGuide.getEmptyIcon();
        }

        File weath;
        if (StyleGuide.getRain().contains(weatherDesc)) {
            weath = StyleGuide.getRainingIcon();
        } else if (StyleGuide.getSunny().contains(weatherDesc)) {
            weath = StyleGuide.getSunnyIcon();
        } else if (StyleGuide.getPartlyCloudy().contains(weatherDesc)){
            weath = StyleGuide.getPartlyCloudyIcon();
        } else if (StyleGuide.getCloudy().contains(weatherDesc)){
            weath = StyleGuide.getCloudyIcon();
        } else if (StyleGuide.getThunderstorm().contains(weatherDesc)){
            weath = StyleGuide.getThunderstormIcon();
        } else if (StyleGuide.getSnow().contains(weatherDesc)){
            weath = StyleGuide.getSnowingIcon();
        } else if (StyleGuide.getWind().contains(weatherDesc)){
            weath = StyleGuide.getWindyIcon();
        } else {
            weath = StyleGuide.getEmptyIcon();
        }

        return new Clothing(accessory, top, bottom, shoes, main, weath);
    }

}
