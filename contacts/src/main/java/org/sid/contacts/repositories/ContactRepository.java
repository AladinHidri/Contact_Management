package org.sid.contacts.repositories;
import org.sid.contacts.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ContactRepository extends JpaRepository<Contact,Long> {
    @Query("select c from Contact c where c.nom like :x")
     Page<Contact> chercher(@Param("x") String mc, Pageable pageable);
}
