package in.anandm.apps;


import in.anandm.apps.entity.ImUser;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class Test {
    public  static  void  main(String args[]){

        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        Resource resource = new ClassPathResource("resources/infrastructure-config/infrastructure.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        SessionFactory sessionFactory = (SessionFactory) beanFactory.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(ImUser.class);
        criteria.add(Restrictions.eq("loginId", "father"));
        System.out.println(criteria.list());
    }
}
