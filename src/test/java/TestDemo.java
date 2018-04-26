import com.atguigu.bean.TMallProduct;
import com.atguigu.bean.TMallProductExample;
import com.atguigu.mapper.TMallProductMapper;
import com.atguigu.service.SpuService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;


/**
 * Created by luwan on 2018/3/23.
 */
public class TestDemo {
   static int x;
    static {
        int x=5;
        x--;

    }
    static {
        x--;
    }
    public static void main(String[] args) {

    }
    private static final Logger logger = Logger.getLogger(TestDemo.class);

    ClassPathXmlApplicationContext ios = new ClassPathXmlApplicationContext("applicationContext.xml");
 /*   @Value("${jdbc.password}")
    private String passsword;*/


    @Autowired
    private SpuService supervice;

    @Test
    public void listTarr(){
        TMallProductMapper tMallProductMapper = (TMallProductMapper) ios.getBean("TMallProductMapper");
        TMallProductExample example=new TMallProductExample();
        TMallProductExample.Criteria criteria = example.createCriteria();
        criteria.andFlbh2EqualTo(28);
        criteria.andFlbh1EqualTo(8);
//        example.or(criteria);

        List<TMallProduct> spu_list = tMallProductMapper.selectByExample(example);
        logger.info(spu_list);
    }


    @Test
    public void filetest(){
        int[] arrry={1,234,43,3,41,4,5,7,88};

        for (int i = 0; i < arrry.length-1; i++) {
            for (int j = 0; j < arrry.length-i-1; j++) {
                if(arrry[j]>arrry[j+1]){
                    int tem=arrry[j];
                    arrry[j]= arrry[j+1];
                    arrry[j+1]=tem;
                }

            }

        }

        for (int i : arrry) {
            System.out.print(i+",");
        }
    }



    @Test
    public void test() throws IOException {

        /*logger.info(passsword+"****************");*/
       /* TMallClass2Mapper tMallClass1Mapper = (TMallClass2Mapper) ios.getBean("TMallClass2Mapper");

        TMallClass2Example example = new TMallClass2Example();

        TMallClass2Example.Criteria criteria = example.createCriteria();

        criteria.andFlbh1EqualTo(8);
        List<TMallClass2> list = tMallClass1Mapper.selectByExample(null);
        Set<Integer> ss = new HashSet<Integer>();
        for (TMallClass2 class2 : list) {
            ss.add(class2.getFlbh1());
        }
        Gson g = new Gson();

        BufferedOutputStream bo = null;
        for (Integer id : ss) {



            bo = new BufferedOutputStream(new FileOutputStream("F://class_2_" + id + ".js"));

            TMallClass2Example example = new TMallClass2Example();

            TMallClass2Example.Criteria criteria = example.createCriteria();

            criteria.andFlbh1EqualTo(id);

            List<TMallClass2> l = tMallClass1Mapper.selectByExample(example);

            String s = g.toJson(l);
            byte[] bytes = s.getBytes();
            bo.write(bytes);
            bo.flush();
        }

        if(bo!=null){
            bo.close();
        }*/

    }
}
