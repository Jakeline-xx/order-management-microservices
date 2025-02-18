package com.fiap.gestao_pedidos_microservice.batch;

import com.fiap.gestao_pedidos_microservice.model.Produto;
import com.fiap.gestao_pedidos_microservice.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import java.math.BigDecimal;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {

//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
    private final ProdutoRepository produtoRepository;

    @Bean
    public FlatFileItemReader<Produto> reader() {
        return new FlatFileItemReaderBuilder<Produto>()
                .name("produtoItemReader")
                .resource(new FileSystemResource("produtos.csv"))
                .delimited()
                .names("nome", "descricao", "preco", "estoque")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Produto.class);
                }})
                .build();
    }

    @Bean
    public ItemProcessor<Produto, Produto> processor() {
        return produto -> {
            if (produto.getPreco().compareTo(BigDecimal.ZERO) > 0) {
                return produto;
            }
            return null;
        };
    }

    @Bean
    public ItemWriter<Produto> writer() {
        return items -> produtoRepository.saveAll(items);
    }

//    @Bean
//    public BatchProperties.Job importProdutoJob(JobCompletionNotificationListener listener, Step step1) {
//        return jobBuilderFactory.get("importProdutoJob")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(step1)
//                .end()
//                .build();
//    }

//    @Bean
//    public Step step1(ItemReader<Produto> reader, ItemProcessor<Produto, Produto> processor, ItemWriter<Produto> writer) {
//        return stepBuilderFactory.get("step1")
//                .<Produto, Produto>chunk(10)
//                .reader(reader)
//                .processor(processor)
//                .writer(writer)
//                .build();
//    }
}
