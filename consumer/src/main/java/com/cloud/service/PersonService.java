package com.cloud.service;
import com.cloud.bean.Person;
import com.cloud.repository.Person2Repository;
import com.cloud.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Oliverlee on 2017/3/25.
 */
@Service
public class PersonService {
    /*
    * Save和Delete需要事物绑定
    *
    * */
    @Resource
    PersonRepository personRepository;

    @Resource
    Person2Repository person2Repository;

    /*
    * 声明Save方法需要事务处理
    * */
    @Transactional
    public void Save(Person person){
        personRepository.save(person);
    }
    public void Delete(int id){
        personRepository.delete(id);
    }
    public Iterable<Person> GetAll(){
        return personRepository.findAll();
    }

    public Person findByperName(String personName){
        return person2Repository.findByperName(personName);
    }

    public Person findMyPersonName(String personName){
        return person2Repository.findMyPersonName(personName);
    }


}
