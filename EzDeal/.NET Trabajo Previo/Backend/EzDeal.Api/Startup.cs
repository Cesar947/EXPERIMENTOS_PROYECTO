using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Options;
using Microsoft.EntityFrameworkCore;   
using EzDeal.Repository.Context; 
using EzDeal.Repository;
using EzDeal.Repository.Implementacion; 
using EzDeal.Service;
using EzDeal.Service.Implementacion;
using Swashbuckle.AspNetCore.Swagger;

namespace EzDeal.Api
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            //Para que se cree sin el comando : dotnet ef --startup-project ../EzDeal.Api migrations add init
            string assemblyName = "EzDeal.Api";
        
            services.AddDbContext<ApplicationDbContext>(options => options.UseSqlServer(Configuration.GetConnectionString("DefaultConnection"),
            optionsBuilder => optionsBuilder.MigrationsAssembly(assemblyName)));

            services.AddTransient<IAnuncioRepository, AnuncioRepository>();
            services.AddTransient<IAnuncioService, AnuncioService>();

            services.AddTransient<IReseñaRepository, ReseñaRepository>();
            services.AddTransient<IReseñaService, ReseñaService>();

            services.AddTransient<ISolicitudRepository, SolicitudRepository>();
            services.AddTransient<ISolicitudService, SolicitudService>();

            services.AddTransient<IUsuarioRepository, UsuarioRepository>();
            services.AddTransient<IUsuarioService, UsuarioService>();

            services.AddMvc().SetCompatibilityVersion(CompatibilityVersion.Version_2_2);

            services.AddSwaggerGen(swagger =>
            {
                var contact = new Contact() { Name = SwaggerConfiguration.ContactName, Url = SwaggerConfiguration.ContactUrl };
                swagger.SwaggerDoc(SwaggerConfiguration.DocNameV1,
                                    new Info
                                    {
                                        Title = SwaggerConfiguration.DocInfoTitle,
                                        Version = SwaggerConfiguration.DocInfoVersion,
                                        Description = SwaggerConfiguration.DocInfoDescription,
                                        Contact = contact
                                    }
                                    );
            });

            services.AddCors(options =>
            {
                options.AddPolicy("Todos",
                builder => builder.WithOrigins("*").WithHeaders("*").WithMethods("*"));
            });



            //services.AddDbContext<ApplicationDbContext>(options => options.UseSqlServer(Configuration.GetConnectionString("DefaultConnection")));
            //services.AddMvc().SetCompatibilityVersion(CompatibilityVersion.Version_2_2);
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            // Enable middleware to serve generated Swagger as a JSON endpoint.
            app.UseSwagger();

            // Enable middleware to serve swagger-ui (HTML, JS, CSS, etc.), specifying the Swagger JSON endpoint.
            app.UseSwaggerUI(c =>
            {
                c.SwaggerEndpoint(SwaggerConfiguration.EndpointUrl, SwaggerConfiguration.EndpointDescription);
            });


            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }
            app.UseCors("Todos");
            //app.UseHttpsRedirection();
            app.UseMvc();
        }
    }
}
