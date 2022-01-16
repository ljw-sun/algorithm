package net.ljw.Linked;

/**
 * @author LIJW
 * @date 2021/8/19 10:17 上午
 * 学习双链表 添加 修改 删除
 */
public class doubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1, "w", "e");
        HeroNode2 heroNode2 = new HeroNode2(2, "e", "c");
        HeroNode2 heroNode4 = new HeroNode2(3, "ll", "c");
        doubleLinkedList doubleLinkedList = new doubleLinkedList();
        doubleLinkedList.addByOrder(heroNode1);
        doubleLinkedList.addByOrder(heroNode2);
        doubleLinkedList.addByOrder(heroNode4);
        doubleLinkedList.list();
        HeroNode2 heroNode3 = new HeroNode2(3, "pppp", "c");
        doubleLinkedList.update(heroNode3);
        System.out.println("===修改后===");
        doubleLinkedList.list();
        System.out.println("===删除后===");
        doubleLinkedList.delete(1);
        doubleLinkedList.list();
    }
}

class doubleLinkedList{

    //创建头节点
    private HeroNode2 head = new HeroNode2(0,"","");


    //根据no排序添加
    public void addByOrder(HeroNode2 heroNode2){
        HeroNode2 temp = head;
        boolean flag = false;

        while (true){
            if (temp.next == null){
                break;
            }

          if (temp.next.no > heroNode2.no){
              break;
          }else if (temp.next.no == heroNode2.no){
              flag = true;
              break;
          }
          temp = temp.next;
        }
        if (flag){
            System.out.println("已经存在，不需要重复添加");
        }else {
            heroNode2.next = temp.next;
            heroNode2.pre = temp;

            if (temp.next != null){
                temp.next.pre = heroNode2;
            }
            temp.next = heroNode2;
        }


    }

    //删除节点 （双向链表可以自身删除）
    public void delete(int nodeInt){
        HeroNode2 temp = head.next;
        if (temp == null){
            System.out.println("链表为空");
            return;
        }

        boolean flag;
        while (true){
            if (temp == null){
                System.out.println("没有找到要删除的节点");
                return;
            }

           if (temp.no == nodeInt){
               flag = true;
               break;
           }
            temp = temp.next;
        }

        if (flag){
            temp.pre.next = temp.next;
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

    }

    //修改双向链表
    public void update(HeroNode2 heroNode2){
        HeroNode2 temp = head.next;

        while (true){
            if (temp == null){
                System.out.println("没有找到要修改的节点");
                return;
            }
            if (temp.no == heroNode2.no){
                break;
            }
            temp = temp.next;
        }
        temp.no = heroNode2.no;
        temp.name = heroNode2.name;
        temp.nickname = heroNode2.nickname;
    }

    //创建链表(添加)
    public void save(HeroNode2 heroNode2){
       HeroNode2 temp = head;


       //自己写法
//       while (true) {
//           if (temp.next == null) {
//               temp.next = heroNode2;
//               heroNode2.pre = temp;
//               break;
//           }
//           temp = temp.next;
//       }
       //老师写法
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    //查看链表
    public void list(){
      HeroNode2 temp = head.next;

        if (temp == null){
            System.out.println("链表为空");
            return;
        }
      while (true){

          if (temp == null){
              break;
          }

          System.out.println(temp);
          temp = temp.next;
      }

    }

}


//定义heroNode，每个HeroNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; //指向下一个节点
    public HeroNode2 pre;  //指向上一个节点

    //构造器
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
