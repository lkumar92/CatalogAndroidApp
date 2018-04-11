package lkum.com.catalogapp;

/**
 * Created by lalkumar1 on 06-Mar-18.
 */

public class ChildSkus {

    private String productId;

    private String skuId;

    private String seqNum;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String childSku) {
        this.skuId = skuId;
    }

    public String getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(String seqNum) {
        this.seqNum = seqNum;
    }

}
