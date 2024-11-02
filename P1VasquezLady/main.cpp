#include <iostream>
#include <fstream>
using namespace std;
float nota1, nota2, nota3, prom;
void VasquezMenu();
void VasquezPromedio(float prom);
void VasquezIngreDatos();
void VasquezGuardarDatos(float nota1, float nota2, float nota3, float prom);
void VasquezLeerDatos();

int main()
{
VasquezMenu();
    return 0;
}

void VasquezMenu(){
int opMenu;
cout<<"REGISTRO DE NOTAS"<<endl;
cout<<"OP1. INGRESO DE NOTAS"<<endl;
cout<<"OP2. CALCULO DE PROMEDIO"<<endl;
cout<<"OP3. SALIR"<<endl;
cin>>opMenu;
switch(opMenu){
case 1:
    VasquezIngreDatos();
    VasquezMenu();
    break;
case 2:
    VasquezPromedio( prom);
    VasquezMenu();
    break;
case 3:
    cout<<"GRACIAS POR USAR ESTE PROGRAMA"<<endl;
    break;
    default: cout<<"ERROR, INGRESE NUEVAMENTE"<<endl;
      break;
}

}

void VasquezIngreDatos(){
cout<<"Ingrese la nota 1 (0-20): "<<endl;
cin>>nota1;
while(nota1<0||nota1>20){
    cout<<"Rango incorrecto, ingrese nuevamente"<<endl;
    cin>>nota1;
}
cout<<"Ingrese la nota 2 (0-20): "<<endl;
cin>>nota2;
while(nota2<0||nota2>20){
    cout<<"Rango incorrecto, ingrese nuevamente"<<endl;
    cin>>nota2;
}
cout<<"Ingrese la nota 3 (0-20): "<<endl;
cin>>nota3;
while(nota3<0||nota3>20){
    cout<<"Rango incorrecto, ingrese nuevamente"<<endl;
    cin>>nota3;
}
prom=(nota1+nota2+nota3)/3;
VasquezGuardarDatos(nota1, nota2, nota3, prom);
}

void VasquezPromedio(float prom){
cout<<"El promedio es: "<<prom<<endl;
if(prom<14){
    cout<<"Reprobado"<<endl;
} else{
cout<<"Aprobado"<<endl;
}
}

void VasquezGuardarDatos(float nota1, float nota2, float nota3, float prom) {
    ofstream archivo("notas.txt");
    if (archivo.is_open()) {
        archivo<<"Nota 1: "<<nota1<<endl;
        archivo<<"Nota 2: "<<nota2<<endl;
        archivo<<"Nota 3: "<<nota3<<endl;
        archivo<<"Promedio: "<<prom<<endl;
        archivo.close();
        cout<<"Datos guardados correctamente en el archivo"<<endl;
    } else {
        cout<<"Error al abrir el archivo para guardar los datos"<<endl;
    }
}
