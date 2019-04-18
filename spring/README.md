# About

This sample shows integration of Spring Web Application with RooX UIDM. 

## Configure properties 

 This sample uses src/main/resources/application.properties, but any Spring configuration system will go.
 
`com.rooxteam.aal.sso.endpoint` UIDM Base Url, like https://wtl.demo.rooxteam.com/sso
`com.rooxteam.aal.auth.client` OAuth Client ID
`com.rooxteam.aal.auth.password` OAuth Client Secret 
`com.rooxteam.aal.jwt.issuer` JWT Issue to check if UIDM SDK works in JWT mode. Not used if SDK validates token on UIDM server, but must be set to any value. 
`com.rooxteam.aal.token.info.forward.attributes` List of token properties (aka claims) that are visible to controllers and business layer.
 
 Typically these properties are provided from Project Manager or Engineer of Support Service.
 
 ## Start Sample API
 
 `gradlew bootRun`
 
 Sample API starts on port 8080.
 
 ## Get Access Token
 
 Authenticate in Web Browser passing one of login use cases.
 Get access token from `at` cookie after it.
 
 ## Invoke Sample API
 
 ```
token=e5e58de5-d62e-4abb-aec4-b7449efc0378 <== token from previous step
curl -v http://localhost:8080/api/tokens/@current -H "Authorization: Bearer sso_1.0_$token"

```
 
 Sample prints authentication context info if provided token is valid.