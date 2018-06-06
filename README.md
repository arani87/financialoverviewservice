# Financial Overview Service

Returns the average monthly income, expense and savings of a customer

```bash
git clone https://github.com/arani87/financialoverviewservice.git
cd financialoverviewservice
mvnw.cmd clean install
docker build -t ssh/financialoverview .
docker run -p 8080:8080 -i ssh/financialoverview
```