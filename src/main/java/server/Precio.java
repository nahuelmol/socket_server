package server;

public class Precio {
        public double euro;

        public double da(){
            return this.euro;
        }
        public void pone(double x){
            this.euro = this.euro + x;
        }
    }