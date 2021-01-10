# gazeus
Lib para usar as chamadas do repósitorio do gitHub

E utilizado o koin para injeção de dependencia devendo ser inicializado

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

                        
                        



