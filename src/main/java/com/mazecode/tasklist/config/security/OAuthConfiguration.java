//package com.mazecode.tasklist.config.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * Class OAuthConfiguration
// *
// * @author Diego Feliú <dfeliu@siga98.net> @DFELIU
// */
//@Configuration
//@EnableAuthorizationServer
//public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {
//
//	private final AuthenticationManager authenticationManager;
//
//	private final PasswordEncoder passwordEncoder;
//
//	private final UserDetailsService userService;
//
//	@Value("${jwt.clientId:glee-o-meter}")
//	private String clientId;
//
//	@Value("${jwt.client-secret:secret}")
//	private String clientSecret;
//
//	@Value("${jwt.signing-key:123}")
//	private String jwtSigningKey;
//
//	@Value("${jwt.accessTokenValidititySeconds:43200}") // 12 hours
//	private int accessTokenValiditySeconds;
//
//	@Value("${jwt.authorizedGrantTypes:password,authorization_code,refresh_token}")
//	private String[] authorizedGrantTypes;
//
//	@Value("${jwt.refreshTokenValiditySeconds:2592000}") // 30 days
//	private int refreshTokenValiditySeconds;
//
//	public OAuthConfiguration(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, UserDetailsService userService) {
//		this.authenticationManager = authenticationManager;
//		this.passwordEncoder = passwordEncoder;
//		this.userService = userService;
//	}
//
//	@Override
//	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		clients.inMemory()
//				.withClient(clientId)
//				.secret(passwordEncoder.encode(clientSecret))
//				.accessTokenValiditySeconds(accessTokenValiditySeconds)
//				.refreshTokenValiditySeconds(refreshTokenValiditySeconds)
//				.authorizedGrantTypes(authorizedGrantTypes)
//				.scopes("read", "write")
//				.resourceIds("api");
//	}
//
//	@Override
//	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) {
//		endpoints
//				.accessTokenConverter(accessTokenConverter())
//				.userDetailsService(userService)
//				.authenticationManager(authenticationManager);
//	}
//
//	@Bean
//	JwtAccessTokenConverter accessTokenConverter() {
//		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//		return converter;
//	}
//
//}