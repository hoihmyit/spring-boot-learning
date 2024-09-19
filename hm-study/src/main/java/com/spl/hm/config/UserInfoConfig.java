package com.spl.hm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "user-info")
@PropertySource(value = "classpath:user.yml", factory = YamlPropertySourceFactory.class)
public class UserInfoConfig {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserInfoConfig{" +
                "users=" + users +
                '}';
    }

    public static class User {
        private String id;
        private String name;
        private String email;
        private String title;
        private List<String> techs = new ArrayList<>();

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getTechs() {
            return techs;
        }

        public void setTechs(List<String> techs) {
            this.techs = techs;
        }

        @Override
        public String toString() {
            return "{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", title='" + title + '\'' +
                    ", techs=" + techs +
                    '}';
        }
    }
}
