package com.study.springboottest.service

import com.study.springboottest.entity.User
import com.study.springboottest.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder,
): IUserService, UserDetailsService {

    override fun saveUser(user: User): Int {
        var user = user
        val passwd: String = user.password
        val encodedPasswod: String = passwordEncoder.encode(passwd)
        user.setPassword(encodedPasswod)
        user = userRepo!!.save(user)
        return user.getId()
    }

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): UserDetails {
        val opt: Optional<User> = userRepo!!.findUserByEmail(email)

        var springUser: org.springframework.security.core.userdetails.User? = null

        if (opt.isEmpty()) {
            throw UsernameNotFoundException("User with email: $email not found")
        } else {
            val user: User = opt.get()
            val roles: List<String> = user.getRoles()
            val ga: MutableSet<GrantedAuthority> = HashSet()
            for (role in roles) {
                ga.add(SimpleGrantedAuthority(role))
            }

            springUser = org.springframework.security.core.userdetails.User(
                email,
                user.getPassword(),
                ga
            )
        }

        return springUser
    } //Other Approach: Using Lambda & Stream API of Java 8
    /*@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {

		Optional<User> opt = userRepo.findUserByEmail(email);

		if(opt.isEmpty())
				throw new UsernameNotFoundException("User with email: " +email +" not found !");
		else {
			User user = opt.get();
			return new org.springframework.security.core.userdetails.User(
					user.getEmail(),
					user.getPassword(),
					user.getRoles()
					.stream()
					.map(role-> new SimpleGrantedAuthority(role))
					.collect(Collectors.toSet())
		    );
		}*/


}

