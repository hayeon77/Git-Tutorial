
class animal{
    String name;
    int old;
    tiger t;

    animal(){
        this("Ʋ�Ⱦ�" , 4444);
    }

   public animal(String name, int old){
        this.name = name;
        this.old = old;
    }



animal Animal = new animal();




    void printInfoOne(){
        System.out.println("���� �� ������ �̸��� : " + this.name);
        System.out.println("���� �� ������ ���̴� : " + this.old);

    }
    void printInfoTwo(){
        System.out.println("���� �� ������ �̸��� : " + this.name);
        System.out.println("���� �� ������ ���̴� : " + this.old);
        System.out.println("���� �� ������ ���� : " + t.variety);
    }
}


class tiger extends animal{
    String variety ;

    tiger(){
        this.variety = "Ʋ�Ⱦ� �̰ԾƴϾ�";
    }
    tiger(String variety){
        this.variety = variety;
    }
}


class overloadingAndPrivate {
    public static void main(String[] args) {

        // ���� Ŭ������ ������ �����ϴ� animal Ŭ������  tigerŬ������ �ֽ��ϴ�.
        // �ٵ� ���� Ű���尡 �̲������� �׸� �ڵ���� ���������ų� ������ �����ڸ� ���� ���ҽ��ϴ�. ã�Ƽ� �ذ� �� �ּ���
        // �ϴ� �ڵ���� �� ���鼭 ������ ������ � ����̿����� �����غ�����.
        // ���� �ڵ忡 ���ٷ� ���� �� �κп� ������ �۾��� ���ֽð�, ���� ���θ޼ҵ忡�� �ҷ��� ����ϼ���.


        // ���� �� �� : ������ ���ٷ� ���� �� ���� ���� or �ۼ� �� �ֽð�, ������ �ڵ�� �������� ���ð�, �� ���� �̿��ϼ���.

        // ���������� ����� ������ ���� ������ ���ּ���
        //-----------------------------------------------
        // ���� �� ������ �̸��� : �ڼ�ȣ
        // ���� �� ������ ���̴� : 31

        // ���� �� ������ �̸��� : ����
        // ���� �� ������ ���̴� : 9
        // ���� �� ������ ���� : superCat
        //-----------------------------------------------

    }
}