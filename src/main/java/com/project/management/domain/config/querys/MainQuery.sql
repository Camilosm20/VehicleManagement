create database vehiclemanagement;

create table vehiclemanagement.vehicle (
	id varchar(30) NOT NULL,
    brand varchar(100),
    color varchar(100),
    id_customer varchar(30),
    PRIMARY KEY (id)
);

create table vehiclemanagement.customer (
	id varchar(30) NOT NULL,
    name varchar(100),
    DNI varchar(30),
    phone int,
    email varchar(100) UNIQUE,
    PRIMARY KEY (id)
);

create table vehiclemanagement.repairs(
	id varchar(30) NOT NULL,
    date_repair date,
    id_mechanic varchar(30),
    PRIMARY KEY (id)
);

create table vehiclemanagement.vehicle_repairs (
	id varchar(30) NOT NULL,
    id_vehicle varchar(30),
    id_repairs varchar(30),
    PRIMARY KEY (id)
);

create table vehiclemanagement.mechanic (
	id varchar(30) NOT NULL,
    name varchar(100),
    DNI varchar(30),
    phone int,
    email varchar(100) UNIQUE,
    PRIMARY KEY (id)
);

alter table vehiclemanagement.vehicle add constraint FK_VehicleCustomer foreign key (id_customer) references vehiclemanagement.customer(id);

alter table vehiclemanagement.repairs add constraint FK_MechanicRepairs foreign key (id_mechanic) references vehiclemanagement.mechanic(id);

alter table vehiclemanagement.vehicle_repairs add constraint FK_VehicleRepairs foreign key (id_vehicle) references vehiclemanagement.vehicle(id);
alter table vehiclemanagement.vehicle_repairs add constraint FK_RepairsVehicle foreign key (id_repairs) references vehiclemanagement.repairs(id);
