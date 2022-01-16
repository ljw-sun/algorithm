package net.ljw.Linked;

/**
 * @author LIJW
 * @date 2021/7/22 4:57 下午
 * 单链表的学习 单纯的链表添加和显示 删除 修改
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode head = new HeroNode(1,"222","dddd");
        HeroNode head2 = new HeroNode(3,"333","ddddfff");
        HeroNode head3 = new HeroNode(2,"333","ddddfff");
        HeroNode head4 = new HeroNode(4,"333","ddddfff");
        HeroNode head5 = new HeroNode(1,"777","888");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(head);
//        singleLinkedList.add(head1);
        singleLinkedList.addByOrder(head);
        singleLinkedList.addByOrder(head2);
        singleLinkedList.addByOrder(head4);
        singleLinkedList.addByOrder(head3);
        singleLinkedList.list();
        singleLinkedList.update(head5);
        singleLinkedList.list();
        singleLinkedList.delete(1);
        singleLinkedList.list();


    }
}

//定义SingleLinkedList 管理我们的英雄
class SingleLinkedList{
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next 指向新的节点
    public void  add(HeroNode heroNode){
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;  //为什么头节点不能动，因为在新添加链表的时候没有找到最后一个链表，则要下移到下一个链表，继续找，如果不使用辅助变量，则下移到一个将会把头节点之前的信息丢掉
        //因为不考虑插入顺序，所以一直找，最后一个链表，找到后跳出循环，把新加入的链表挂载上去
        while (true){
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有找到最后一个，就将temp后移，继续找最后一个
            //把下一个节点给到辅助temp
            temp = temp.next;   //这里就是为什么头节点不能动的原因，因为要下移到下一个链表，来找最后一个链表
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向新的节点
        temp.next = heroNode;
    }

    //第二种方式在添加英雄的时候，根据排名将英雄插入到指定位置
    //如果有这个排名了，则添加失败，并给出提示
    public void addByOrder(HeroNode heroNode){

        //老规矩 头节点不能动，创建辅助指针变量，找到添加的位置
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){  //如果成立则说明已经到了链表的最后了
                break;
            }
            //属于按值插入  单链表 单，插入第i个位置，就找i+1结点，插后面，双，前后都行
            if (temp.next.no > heroNode.no){
                break;
            }else if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next; //后移 ，继续遍历当前链表
        }
        if (flag){
            System.out.println("编号已经存在");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改链表 自己写法
    public void update(HeroNode heroNode){

        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //辅助变量
        HeroNode temp = head.next;
        boolean flag= false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == heroNode.no){
                flag = true;
                temp.name = heroNode.name;
                temp.nickname = heroNode.nickname;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("修改成功");
        }else {
            System.out.println("未找到失败");
        }

    }


    //删除链表 自己写法
    public void delete(int nodeInt){
       HeroNode temp = head;
       boolean flag = false;
       while (true){
           if (temp.next == null){
               break;
           }
           if (temp.next.no == nodeInt){
               temp.next = temp.next.next;
               flag = true;
           }
           temp = temp.next;
       }

       if (flag){
           System.out.println("删除成功");
       }else {
           System.out.println("删除失败");
       }
    }



    //显示链表【遍历】
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，所以我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
           //判断链表是否到了最后一个
            if (temp == null){
                break;
            }
            //输出节点到信息
            System.out.println(temp);
            //后移到下一个节点链表
            temp = temp.next;
        }

    }
}

//定义heroNode，每个HeroNode 对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点
    //构造器

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法，重写toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
