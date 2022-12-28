package pe.com;

import com.intuit.karate.junit5.Karate;

class MascotasRunner {
    
    @Karate.Test
    Karate testUsers() {
        return Karate.run("mascotas").relativeTo(getClass());
    }    

}
