package utilities;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.MinioException;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.GetObjectArgs;
import io.minio.messages.Bucket;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MinioDigitalOceanExample {
    public static void main(String[] args) {
        String endpoint = "https://piimagens.nyc3.digitaloceanspaces.com";
        String accessKey = "DO00PRF76DJE9D3JM4NF";
        String secretKey = "I58SAOQdksspISKJ5fpYIHR6rzQEzT88+YtozSXEP5M";
        String bucketName = "piimagens";

        try {
            // Crie uma instância do cliente MinIO
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(endpoint)
                    .credentials(accessKey, secretKey)
                    .build();

            // Verifique se o bucket (Space) existe e crie-o se não existir
            boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!bucketExists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }

            // Lista todos os buckets para verificar se o bucket foi criado com sucesso
            Iterable<Bucket> buckets = minioClient.listBuckets();
            for (Bucket bucket : buckets) {
                System.out.println("Bucket: " + bucket.name());
            }

            // Baixe o objeto "download.jpeg" do bucket "piimagens" e salve localmente
            String objectName = "download.jpeg";
            Path localFilePath = Paths.get("../imgs/download.jpeg");
            minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(objectName).build());

            System.out.println("Objeto baixado com sucesso: " + localFilePath);

        } catch (MinioException e) {
            System.out.println("Erro MinIO ocorreu: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
