import java.util.ArrayList;
import java.util.List;

interface MediatorEntity {

    public void registerBidder(CollegueEntity_Bidder bd);

    public void searchHighestBidAmount();

}

abstract class CollegueEntity_Bidder {
    MediatorEntity md;
    String bName;
    int bPrice;

    public CollegueEntity_Bidder(MediatorEntity md, String bName) {
        this.md = md;
        this.bName = bName;
        // this.bPrice = bPrice;
    }

    abstract public void bidAmount(int amount);

    public String toString() {
        return "CollegueEntity_Bidder [md=" + md + ", bName=" + bName + ", bPrice=" + bPrice + "]";
    }

    public int getbPrice() {
        return bPrice;
    }
}

class Bidder1 extends CollegueEntity_Bidder {

    public Bidder1(MediatorEntity md, String bName) {
        super(md, bName);
    }

    public void bidAmount(int amount) {
        bPrice = amount;
    }

}

class AuctionMediator implements MediatorEntity {
    List<CollegueEntity_Bidder> ls = new ArrayList<CollegueEntity_Bidder>();

    public void registerBidder(CollegueEntity_Bidder bd) {
        ls.add(bd);
    }

    public void searchHighestBidAmount() {
        int maxBid = 0;
        CollegueEntity_Bidder b = null;
        for (CollegueEntity_Bidder cb : ls) {
            if (cb.getbPrice() > maxBid) {
                maxBid = cb.getbPrice();
                b = cb;
            }
        }

        System.out.println("Winner of the auctioning is : " + b);
    }

}

class MediatorDemo {
    public static void main(String[] args) {
        MediatorEntity m1 = new AuctionMediator();

        CollegueEntity_Bidder b1 = new Bidder1(m1, "Bidder1");
        CollegueEntity_Bidder b2 = new Bidder1(m1, "Bidder2");
        CollegueEntity_Bidder b3 = new Bidder1(m1, "Bidder3");

        System.out.println("Bienvenue Tu all Bidder pour auctioning event:");

        m1.registerBidder(b1);
        m1.registerBidder(b2);
        m1.registerBidder(b3);

        b1.bidAmount(5000);
        b2.bidAmount(2000);
        b3.bidAmount(7200);

        m1.searchHighestBidAmount();
    }
}