package com.terry.nlp;

public class Words {
    private String inputtext;
    private String result;
    /**
     * @return the inputtext
     */
    public String getInputtext() {
        return inputtext;
    }
    /**
     * @param inputtext the inputtext to set
     */
    public void setInputtext(String inputtext) {
        this.inputtext = inputtext;
    }
    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }
    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Words [inputtext=" + inputtext + ", result=" + result + "]";
    }
    
    

}
