# gazeus
Lib para usar as chamadas do repósitorio do gitHub


Para importa a lib versão atual 0.0.1

gradle 

    Adicione-o em seu build.gradle raiz no final dos repositórios:

    allprojects {
        repositories {
          ...
          maven { url 'https://jitpack.io' }
        }
      }


    Adicione a dependência

    dependencies {
              implementation 'com.github.RafaelDouglasOliveira:gazeus:Tag'
    }
maven

    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
      </repositories>
      
      Adicione a dependência
      
      dependency>
        <groupId>com.github.RafaelDouglasOliveira</groupId>
        <artifactId>gazeus</artifactId>
        <version>Tag</version>
      </dependency>

      
_____________________________________________________________________________________________________________

E utilizado o koin para injeção de dependencia devendo ser inicializado no app principal

_____________________________________________________________________________________________________________

Para pesquisar repositórios publicos por nome: 

coreProvider.getRepositoryUserName(nameUser : String, callback: (Boolean, List<Repos>?) -> Unit)
o callback o Boolean do callback retorna true em caso de sucesso e false caso apresente erro

_____________________________________________________________________________________________________________

Para pesquisar tags de um determinadno repósitorio:

coreProvider.getTagOwnerRepo(owner: String,
                        repo : String,
                        callBack: (success: Boolean, data: List<TagRepo>?)

o callback o Boolean do callback retorna true em caso de sucesso e false caso apresente erro

_____________________________________________________________________________________________________________

                        
                        



