package net.java.games.input;

class UsagePair {
    private final Usage usage;
    private final UsagePage usage_page;

    public UsagePair(UsagePage usagePage, Usage usage2) {
        Usage usage3 = usage2;
        this.usage_page = usagePage;
        this.usage = usage3;
    }

    public final boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof UsagePair) {
            UsagePair usagePair = (UsagePair) obj2;
            if (usagePair.usage.equals(this.usage) && usagePair.usage_page.equals(this.usage_page)) {
                return true;
            }
        }
        return false;
    }

    public final Usage getUsage() {
        return this.usage;
    }

    public final UsagePage getUsagePage() {
        return this.usage_page;
    }

    public final int hashCode() {
        return this.usage.hashCode() ^ this.usage_page.hashCode();
    }

    public final String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        return stringBuffer2.append("UsagePair: (page = ").append(this.usage_page).append(", usage = ").append(this.usage).append(")").toString();
    }
}
