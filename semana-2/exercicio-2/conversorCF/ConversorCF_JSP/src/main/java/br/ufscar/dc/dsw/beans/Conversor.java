package br.ufscar.dc.dsw.beans;



public class Conversor {
    private int min,max,inc;

    public Conversor() {
        super();
    }
    
    public void setMin(final int min) {
        this.min = min;
    }
    
    public int getMin() {
        return min;
    }
    
    public void setMax(final int max) {
        this.max = max;
    }
    
    public int getMax(){
        return max;
    }

    public void setInc(final int inc) {
        this.inc = inc;
    }
    
    public int getInc() {
        return inc;
    }
    
    
}