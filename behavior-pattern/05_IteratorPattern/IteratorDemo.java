import java.util.ArrayList;
import java.util.List;

class Channel {
    private double number;
    private String type;

    public Channel(double number, String type) {
        this.number = number;
        this.type = type;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Channel [number=" + number + ", type=" + type + "]";
    }

}

class ChannelIterator {
    List<Channel> l;
    int position = 0;

    public ChannelIterator(ChannleCollection cc) {
        l = cc.getChanneList();
    }

    public Channel getNext() {
        Channel c = l.get(position);
        position++;
        return c;
    }

    public boolean hasNext() {
        Channel c = l.get(position);
        return (c != null);
    }
}

class ChannleCollection {
    List<Channel> channelList = new ArrayList<Channel>();

    public List<Channel> getChanneList() {
        return channelList;
    }

    public void addChannel(Channel c) {
        channelList.add(c);
    }

    public void removeChannel(Channel c) {
        channelList.remove(c);
    }

    public ChannelIterator getIterator() {
    }
}

class IteratorDemo {
    public static void main(String[] args) {
        Channel 
    }
}