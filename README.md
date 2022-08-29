# APIsJava
### Consumo de algunas APIs de la Reniec con Java EE

* Java : JDK 11
* Project: Maven Web Application
* Server: WildFly Application Server
* Java EE Versión: Java EE 7 Web
* Frameworks: JSF y Primefaces

I. **Fuente 1: [dniruc.apisperu.com](https://dniruc.apisperu.com/api/v1/dni/)**

	1. Consulta DNI:

		GET: https://dniruc.apisperu.com/api/v1/dni/{dni}?token{token}

	2. Consulta RUC

		GET: https://dniruc.apisperu.com/api/v1/ruc/{ruc}?token{token}


II. **Fuente 2: [apiperu](https://apiperu.dev/)**


	1. Consulta DNI:

	**Headers**

	 Content-Type  | string     |  application/json
	 ------------- | ---------- |  ------------------
	 Authorization |  string    |  Bearer {token}

	2. Consulta RUC

	**Headers**

	 Content-Type  | string     |  application/json
	 ------------- | ---------- |  ------------------
	 Authorization |   string   |  Bearer {token}

	3. Consulta de Validez CPE
	4. Consulta del Tipo de Cambio