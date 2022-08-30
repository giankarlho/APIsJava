# APIsJava
### Consumo de algunas APIs de consulta SUNAT con Java EE

* Java : JDK 11
* Project: Maven Web Application
* Server: WildFly Application Server
* Java EE Versión: Java EE 7 Web
* Frameworks: JSF 2.3 y Primefaces 11.0
* Librarys: OkHttp 4.9.0, lombok 1.18.20, unirest 1.4.9
--- 
I. **Fuente 1: [dniruc.apisperu.com](https://dniruc.apisperu.com/api/v1/dni/)**

	1. Consulta DNI:

		> **GET:** https://dniruc.apisperu.com/api/v1/dni/{dni}?token{token}

	2. Consulta RUC

		> **GET:** https://dniruc.apisperu.com/api/v1/ruc/{ruc}?token{token}

    **Librarys and Class/Package services**
    
    * ReniecS1 -> Gson 2.8.6
---
II. **Fuente 2: [apiperu](https://apiperu.dev/)**


	1. Consulta DNI:

        > **GET:** https://apiperu.dev/api/dni/{token}

	    **Headers**

	    Content-Type  | string     |  application/json
	    ------------- | ---------- |  ------------------
	    Authorization |  string    |  Bearer {token}

        **Librarys and Class/Package services**
        * ReniecS2 -> Unirest 1.4.9
        * ReniecS3 -> OkHttp 4.9.0
    

	2. Consulta RUC

	    > **GET:** https://apiperu.dev/api/ruc/{token}
	    
	    **Headers**

	     Content-Type  | string     |  application/json
	    ------------- | ---------- |  ------------------
	    Authorization |   string   |  Bearer {token}

	3. Consulta de Validez CPE
	4. Consulta del Tipo de Cambio