package ru.techcave;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.stream.Stream;

@SpringBootApplication
public class DeviceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(DeviceRepository deviceRepository) {
	    return strings -> {
            Stream.of(new Device("iPhone"), new Device("macbook"))
                    .forEach(deviceRepository::save);

            deviceRepository.findAll().forEach(System.out::println);

            Device macbook = deviceRepository.findByName("macbook");
            System.out.println(macbook);
        };
    }
}

@RepositoryRestResource
interface DeviceRepository extends JpaRepository<Device, Long> {
    Device findByName(String name);
}

@Entity
@Data
@NoArgsConstructor
class Device {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Device(String name) {
        this.name = name;
    }
}
